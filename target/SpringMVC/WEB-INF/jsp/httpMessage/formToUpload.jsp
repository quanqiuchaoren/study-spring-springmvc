<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/30
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>入参使用@RequestBody</title>
</head>
<body>
    <%--上传文件都要使用post方法%>
    <%表单提交的数据的格式要使用二进制流的方式：enctype="multipart/form-data"--%>
    <form action="${pageContext.request.contextPath}/messageConverter/upload" method="post"
        enctype="multipart/form-data">

        文件：<input name="doupocangqiong" type="file"><br><br>
        说明：<input name="说明" type="text"><br><br>
              <input type="submit" value="上传">
    </form>
</body>
</html>
