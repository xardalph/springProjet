<%--@elvariable id="user" type="org.epsi.model.User"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>login</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

    <h3>login</h3>
<form:form method="POST" action="/user/login" modelAttribute="user" >
    <br/>
    <form:label path="login"> Login</form:label>
    <form:input path="login"/>
    <br/>
    <form:label path="password">password</form:label>
    <form:input path="password"/>

    <input type="submit" value="submit"></input>
</form:form>

<jsp:include page="../_bootstrap_js.jsp"></jsp:include>