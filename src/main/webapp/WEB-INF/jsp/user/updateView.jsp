<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/28
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>修改用户</title>
</head>
<body>
    SpringMvc的表单
    <form:form action="${pageContext.request.contextPath}/user/user" method="put" modelAttribute="user">
        <form:hidden path="id"/><br><br>
        <form:input path="username"/><br><br>
        <form:select path="business.id" items="${businesses}" itemValue="id" itemLabel="businessName" />
        <br><br>
        <input type="submit" value="修改用户"><br><br>
    </form:form>

    普通表单
    <form action="${pageContext.request.contextPath}/user/user" method="post">
        <%--在web.xml中配置了HiddenHttpMethodFilter之后，再在页面上加以下代码，就可以实现post转换为put请求--%>
        <input type="hidden" name="_method" value="put">
        <input name="username">
        <input type="submit" value="修改(put)">
    </form>






</body>
</html>
