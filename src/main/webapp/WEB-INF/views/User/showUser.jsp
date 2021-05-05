<%--@elvariable id="user" type="org.epsi.model.User"--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html>
<head>
<title>show user</title>
    <jsp:include page="../_menu.jsp"></jsp:include>

<h3>Show User</h3>


<div class="w-50">

    <table class="table table-bordered table-striped table-dark">
        <thead>
        <tr>

        </tr>
        </thead>
        <tbody>
        <tr>
            <th scope="col">Login</th>
            <td>${user.login}</td>
        </tr>
        <tr>
            <th scope="col">name</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th scope="col">username</th>
            <td>${user.username}</td>
        </tr>
        <tr>
            <th scope="col">password</th>
            <td><c:if test="${!empty user.username}">**********</c:if>
                </td>
        </tr>
        <tr>
            <th scope="col">adresse</th>
            <td>${user.address}</td>
        </tr>
        </tbody>
    </table>
</div>

<jsp:include page="../_bootstrap_js.jsp"></jsp:include>

