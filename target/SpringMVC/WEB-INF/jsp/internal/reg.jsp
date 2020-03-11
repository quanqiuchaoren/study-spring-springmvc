<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/24
  Time: 20:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>国际化注册页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/messageSource/reg">
        <fmt:message key="i18n.username" />：<input type="text" name="username">
        <fmt:message key="i18n.password" />：<input type="text" name="password">
        <input type="submit" value="提交">
    </form>
</body>
</html>
