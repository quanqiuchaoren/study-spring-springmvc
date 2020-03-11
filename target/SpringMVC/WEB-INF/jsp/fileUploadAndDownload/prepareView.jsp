<%--
  Created by IntelliJ IDEA.
  User: windows
  Date: 2018/12/30
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传和下载准备页面</title>
</head>
<body>
<h3>上传文件：</h3>：
<%--上传文件都要使用post方法%>
<%表单提交的数据的格式要使用二进制流的方式：enctype="multipart/form-data"--%>
<form action="${pageContext.request.contextPath}/uploadAndDownload/upload" method="post"
      enctype="multipart/form-data">

    说明：<input name="mark" type="text"><br><br>
    文件：<input name="file" type="file"><br><br>
          <input type="submit" value="上传">
</form>
<br><br><br><br>

<h3>下载指定名字的文件：</h3>：
<form action="${pageContext.request.contextPath}/uploadAndDownload/download" method="get">
    <input name="fileName">
    <input type="submit" value="下载">
</form>

</body>
</html>
