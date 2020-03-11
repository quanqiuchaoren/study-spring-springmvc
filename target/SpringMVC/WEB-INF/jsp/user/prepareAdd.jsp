<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<body>

SpringMvc的表单
<form:form action="${pageContext.request.contextPath}/user/user" method="post" modelAttribute="user">
    <%--添加新用户，不用写id--%>
    <%--<form:hidden path="id"/><br><br>--%>
    姓名：<form:input path="username"/><form:errors path="username" /> <br><br>
    密码：<form:input path="password" /><form:errors path="password" /> <br><br>
    年龄：<form:input path="age" /><form:errors path="age" /> <br><br>
    身高：<form:input path="height" /><form:errors path="height" /> <br><br>
    邮箱：<form:input path="email" /><form:errors path="email" /> <br><br>
    生日：<form:input path="birthday" /><form:errors path="birthday" /> <br><br>
    地区：<form:select path="business.id" items="${businesses}" itemValue="id" itemLabel="businessName" />
    <br><br>
    <%--spring的form表单里面，也可以使用普通的jsp和html标签--%>
    <input type="submit" value="添加用户"><br><br>
</form:form>
</body>
</html>
