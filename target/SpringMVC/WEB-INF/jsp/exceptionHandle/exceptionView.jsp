<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/31
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SpringMVC：异常处理技术</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/exceptionHandle/result">
        被除数：<input name="figure" type="text">
        提  示：${exception}<br><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
