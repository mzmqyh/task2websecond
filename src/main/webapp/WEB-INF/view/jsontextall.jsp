<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/16
  Time: 17:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<json:object>
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message" value="${message}"></json:property>
    <json:array name="data" items="${student}" var="student">
        <json:object>
        <json:property name="name" value="${student.name}"/>
        <json:property name="id" value="${student.id}"/>
        <json:property name="qq" value="${student.qq}"/>
        </json:object>
    </json:array>
</json:object>A


