<jsp:useBean id="product" scope="request" type="org.epsi.model.Product"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>product List</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

    <h3>produit</h3>
    <br/>${product.codeProduit}
    <br/>${product.name}
    <br/>${product.quantity}


<jsp:include page="../_bootstrap_js.jsp"></jsp:include>