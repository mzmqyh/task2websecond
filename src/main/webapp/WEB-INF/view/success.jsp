<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/16
  Time: 17:37
  To change this template use File | Settings | File Templates.--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>
<%--上边为json-taglib的头，必须有才能使用json-taglib标签--%>

<%--<json:object>
    <json:property name="学生姓名" value="${student.name}"/>
    <json:property name="学生姓名" value="${student.name}"/>
</json:object>--%>
<json:object>
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message" value="${message}"></json:property>
</json:object>
