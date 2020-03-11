<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/21
  Time: 21:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="tags" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>name测试</title>
</head>
<body>


    <%--没有定义之前，就是使用的下面这种默认的命名方式--%>
    <%--<a href="${tags:mvcUrl('UC#nameTransfer').build()}">测试@RequestMapping的name属性，即将跳转到index</a>--%>

    <%--下面的href111的名字是在@RequestMapping中定义的--%>
    <a href="${tags:mvcUrl('href111').build()}">测试@RequestMapping的name属性，即将跳转到index</a>



</body>
</html>
