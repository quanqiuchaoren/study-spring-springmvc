<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/30
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>数据提交页面</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/iniBinder/customDateEditor">
        姓名：<input name="username"><br><br>
        年龄：<input name="age"><br><br>
        生日：<input name="birthday"><br><br>
        身高：<input name="height"><br><br>
              <input type="submit" value="提交"><br><br>
    </form>
</body>
</html>
