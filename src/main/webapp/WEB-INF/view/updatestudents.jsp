<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/14
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>更改用户信息</title>
</head>
<body>
<h1>更改用户信息</h1>
<form action="/students/student/${id}" method="POST">
    <input type="hidden" name="_method" value="PUT">
    <input type="hidden" name="id" value = "${student.id}"><br>
    姓名:<input type="text" name="name" value = "${student.name}"><br>
    QQ:<input type="text" name="qq" value = "${student.qq}"><br>
    学号:<input type="text" name="number" value = "${student.number}"><br>
    教练:<input type="text" name="coachName" value = "${student.coachName}"><br>
    日报链接 :<input type="text" name="dailyLink" value = "${student.dailyLink}"><br>
    毕业学校 :<input type="text" name="gradeColleage" value = "${student.gradeColleage}"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
