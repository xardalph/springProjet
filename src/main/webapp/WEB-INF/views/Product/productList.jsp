<%--@elvariable id="user" type="org.epsi.model.User"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>product List</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

    <h3>liste des produits</h3>


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
                <td>${product.code_Produit}</td>
                <td>${product.nom}</td>
                <td>${product.quantite}</td>
                <td>
                    <a href="editProduct?code=${product.code}">Edit</a>
                </td>
                <td>
                    <a href="deleteProduct?code=${product.code}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>

