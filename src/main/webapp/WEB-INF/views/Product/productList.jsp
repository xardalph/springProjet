<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="now" class="java.util.Date"/>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>product List</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

    <h3>liste des produits</h3>
<br/>

    <p>

        <b><c:out value="${now}"/></b>
    </p>

    <table class="table table-bordered table-striped table-dark" >
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>quantité</th>
            <th>date</th>
            <th>périmé ?</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <%--@elvariable id="productList" type="java.util.List"--%>
        <c:forEach items="${productList}" var="product" >
            <tr>

                <td>${product.codeProduit}</td>
                <td>${product.name}</td>
                <td>${product.quantity}</td>
                <td>${product.dateLimiteConso}</td>

                <td><c:if  test="${product.dateLimiteConso <= now}">
                    PERIME
                </c:if>
                </td>
                <td>
                <a href="/product/update/${product.id}">Edit</a>
                </td>
                <td>
                    <a href="/product/delete/${product.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>

    </table>


<jsp:include page="../_bootstrap_js.jsp"></jsp:include>