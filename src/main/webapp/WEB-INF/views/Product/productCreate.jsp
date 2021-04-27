<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <title>product List</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

    <h3>liste des produits</h3>
    <br/>
<%--@elvariable id="product" type="org.epsi.model.Product"--%>
<form:form method="POST" action="/product/create" modelAttribute="product" >
    <br/>
    <form:label path="name">name</form:label>
    <form:input path="name"/>
    <br/>
    <form:label path="codeProduit">code</form:label>
    <form:input path="codeProduit"/>
    <br/>
    <form:label path="dateLimiteConso">date limite de consomation</form:label>
    <form:input path="dateLimiteConso" type="date"/>
    <br/>
    <form:label path="quantity">quantité</form:label>
    <form:input path="quantity" />
    <br/>
    <input type="submit" value="submit"/>

</form:form>

<jsp:include page="../_bootstrap_js.jsp"></jsp:include>