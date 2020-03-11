<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>String转换成User</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/modifyConverterController/stringToUser" method="post">
        输入格式：（id，username，age）<input name="user"><br><br>
        <input type="submit" value="提交">
    </form>
</body>
</html>
