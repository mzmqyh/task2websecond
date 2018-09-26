<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/14
  Time: 17:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" isErrorPage="true" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<html>
<head>
    <title>students</title>
</head>
<body>
<table align="center" border="1" cesllspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>qq</td>
        <td>number</td>
        <td>coachName</td>
        <td>dailyLink</td>
        <td>gradeGollege</td>
        <%--<td>create_at</td>--%>
        <%--<td>update_at</td>--%>
        <td>delete</td>
        <td>update</td>
    </tr>

    <c:forEach items="${studentsList}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.name}</td>
            <td>${item.qq}</td>
            <td>${item.number}</td>
            <td>${item.coachName}</td>
            <td>${item.dailyLink}</td>
            <td>${item.gradeColleage}</td>
                <%--<td>${item.create_at}</td>--%>
                <%--<td>${item.update_at}</td>--%>
            <td><a  type="button" href="/students/student/dele/${item.id}">删除</a></td>
            <td><a   type="button" href="/students/student/${item.id}">编辑</a></td>
        </tr>
    </c:forEach>
    <td><a type="button" href="/students/student">插入</a></td>
    <input type="hidden" name="start" value = "${page.start}"><br>
    <div style="text-align:center">
        <a href="/students/students?start=0">首  页</a>
        <a href="/students/students?start=${page.start-page.count}">上一页</a>
        <a href="/students/students?start=${page.start+page.count}">下一页</a>
        <a href="?start=${page.last}">末  页</a>
        第 <input type="text" name="p" value = ${page.start/page.count+1} > 页
      <a href="/students/students?start=${(p-1)*page.count}">跳转</a>
    </div>
</table>
</body>
</html>
