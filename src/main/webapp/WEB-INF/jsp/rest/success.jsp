<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/25
  Time: 20:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成功页面</title>
</head>
<body>
    操作成功<br><br>

    get:${requestScope.user}<br><br>
    post:${requestScope.post}<br><br>
    put:${requestScope.put}<br><br>
    delete:${requestScope.delete}<br><br>
</body>
</html>
