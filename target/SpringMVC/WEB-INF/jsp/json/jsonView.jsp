<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ajax</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.2.3.min.js"></script>
</head>
<body>
    老方法：<a id="jsonTest1" href="${pageContext.request.contextPath}/ajax/getUsersJson1">获取users的json串</a>
            <br><br>
    新方法：<a id="jsonTest2" href="${pageContext.request.contextPath}/ajax/getUsersJson2">获取users的json串</a>
</body>
</html>

<script type="text/javascript" >
    $(function () {
        $("#jsonTest1").click(getJsonString);
        $("#jsonTest2").click(getJsonString);
    });
</script>

<script type="text/javascript">
    alert("出现此弹框表示：静态资源没有被拦截器拦截")
    function getJsonString () {
        var url = this.href;
        var args = {};

        $.ajax({
            url: url, // 后台url
            type: "POST", // 提交方法
            dataType: "json", // 返回数据类型
            data: {},
            //数据返回类型，可以是xml、json等
            success: function (result) {
                alert("数据量 = " + result.length);
                for (i=0; i<result.length; i++){
                    var id = result[i].id;
                    var username = result[i].username;
                    alert("id:" + id + ", username:" + username);
                }
                // 成功，回调函数
                var json = JSON.stringify(data);//格式化Json数据
                var a = eval('(' + json + ')');//转json字符串
                alert(a.row);
            },

            error: function (er) { // 失败，回调函数
                //  alert('修改错误');
                alert(er)
            }
        });
        // 使原来的a标签的点击事件失效
        return false;
    }
</script>