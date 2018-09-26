<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/14
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/students/student/${id}" method="POST">
    <input type="hidden" name="_method" value="DELETE">
    <%--<input type="hidden" name="id" value="${id}"/>--%>
    <input type="submit" value="确认删除？"/>
</form>
</body>
</html>
