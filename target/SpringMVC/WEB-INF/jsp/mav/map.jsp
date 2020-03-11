<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/23
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Map</title>
</head>
<body>
    <c:forEach var="map" items="${userMap}">
        姓名：${map.key}
        住址：${map.value}
    </c:forEach>
</body>
</html>
