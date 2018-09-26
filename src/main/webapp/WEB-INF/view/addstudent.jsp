<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/14
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>添加用户</title>
</head>
<body>
<h1>添加用户</h1>
<form action="/students/student"  method="POST" target="_blank">
    姓名:<input type="text" name="name"><br>
    QQ:<input type="text" name="qq"><br>
    学号:<input type="text" name="number"><br>
    教练:<input type="text" name="coachName"><br>
    日报链接 :<input type="text" name="dailyLink"><br>
    毕业学校 :<input type="text" name="gradeGollege"><br>
    <input type="hidden" name="start" value = "${page}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>