
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户相关</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/static/jquery-1.2.3.min.js"></script>
    <script type="text/javascript">
        $(function () {
            // alert("jq引入成功。。。。")
            $(".delete").click(function () {
                var href = this.href; // jq的写法：$("this").attr("href");
                alert(href);
                $("#delForm").attr("action", href).submit();
                /*返回false是让超链接原来的点击的功能失效*/
                return false;
            });
        });
    </script>

</head>
<body>
    <form id="delForm" action="" method="post">
        <input type="hidden" name="_method" value="delete">
    </form>


    <table>
        <tr>
            <th>用户名</th>
            <th>密码</th>
            <th>生日</th>
            <th>所属地区</th>
            <th>用户操作：修改</th>
            <th>用户操作：删除</th>
        </tr>
        <c:forEach var="user" items="${users}">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>S${user.birthday}</td>
                <td>${user.business.businessName}</td>
                <td><a href="${pageContext.request.contextPath}/user/user/${user.id}">修改</a> </td>
                <td><a class="delete" href="${pageContext.request.contextPath}/user/user/${user.id}">删除</a> </td>
            </tr>
        </c:forEach>
    </table>
    <h4>
        <a href="${pageContext.request.contextPath}/user/user">添加用户</a>
    </h4>

</body>
</html>

<script>


</script>