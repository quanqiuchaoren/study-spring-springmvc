<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/23
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ModelAndView</title>
</head>
<body>
    name:${requestScope.name}<br><br>
    user1:${requestScope.user1}<br><br>
    users:${requestScope.users}<br><br><br><br>
    遍历users：<br>
    <c:forEach var="user" items="${users}">
        username:${user.username}<br>
        age:${user.age}<br>
    </c:forEach>
    <br><br>


</body>
</html>
