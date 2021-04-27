<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>product List</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

    <h3>liste des produits</h3>
<br/>

    <table class="table table-bordered table-striped table-dark" >
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>quantité</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%--@elvariable id="productList" type="java.util.List"--%>
        <c:forEach items="${productList}" var="product" >
            <tr>

                <td>${product.codeProduit}</td>
                <td>${product.name}</td>
                <td>${product.quantity}</td>
                <td>
                    <a href="editProduct?code=${product.id}">Edit</a>
                </td>
                <td>
                    <a href="deleteProduct?code=${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>

