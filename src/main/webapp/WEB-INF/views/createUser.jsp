<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
  <head>
     <meta charset="UTF-8">
     <title>new user</title>
  </head>
  <body>

     <jsp:include page="_menu.jsp"></jsp:include>

      <h3>Create User</h3>

     <%--@elvariable id="user" type="org.epsi.model.User"--%>
    <form:form method="POST" action="/user/create" modelAttribute="user" >
        <br/>
        <form:label path="login"> Login</form:label>
        <form:input path="login"/>
        <br/>
        <form:label path="name">name</form:label>
        <form:input path="name"/>
        <br/>
        <form:label path="username">username</form:label>
        <form:input path="username"/>
        <br/>
        <form:label path="password">password</form:label>
        <form:input path="password"/>
        <br/>
        <form:label path="address">address</form:label>
        <form:input path="address"/>
        <br/>

        <input type="submit" value="submit">
            Submit
        </input>

    </form:form>


  </body>
</html>
