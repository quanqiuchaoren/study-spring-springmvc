<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/25
  Time: 21:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>准备创建请求页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/RESTFUL/put/1" method="post">
        <%--在web.xml中配置了HiddenHttpMethodFilter之后，再在页面上加以下代码，就可以实现post转换为put请求--%>
        <input type="hidden" name="_method" value="put">
        <input name="username">
        <input type="submit" value="修改用户名(put)">
    </form>

    <form action="${pageContext.request.contextPath}/RESTFUL/delete/1" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="提交delete请求">
    </form>

</body>
</html>
