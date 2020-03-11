<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/23
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>@SessionAttribute</title>
</head>
<body>
    sessionScope:<br>
    sessionScope.id:${sessionScope.id}<br><br>
    sessionScope.username:${sessionScope.username}<br><br>
    sessionScope.user1:${sessionScope.user1}<br><br>
    sessionScope.user2:${sessionScope.user2}<br><br><br><br>

    requestScope:<br>
    requestScope.id:${requestScope.id}<br><br>
    requestScope.username:${requestScope.username}<br><br>
    requestScope.user1:${requestScope.user1}<br><br>
    requestScope.user2:${requestScope.user2}<br><br>
</body>
</html>
