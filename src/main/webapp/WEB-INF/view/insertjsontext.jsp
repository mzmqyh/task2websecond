<%--
  Created by IntelliJ IDEA.
  User: qyh
  Date: 2018/9/20
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="json" uri="http://www.atg.com/taglibs/json" %>

<json:object>
    <json:property name="code" value="${code}"></json:property>
    <json:property name="message" value="${message}"></json:property>
</json:object>