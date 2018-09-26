<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/20
  Time: 13:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message" value="${message}"></json:property>

    <json:property name="id" value="${studentslist.id}"/>
    <json:property name="姓名" value="${student.name}"/>
    <json:property name="学号" value="${student.number}"/>
    <json:property name="QQ" value="${student.qq}"/>
    <json:property name="师兄" value="${student.coachName}"/>
    <json:property name="毕业院校" value="${student.gradeColleage}"/>
    <json:property name="日报链接" value="${student.dailyLink}"/>
</json:object>