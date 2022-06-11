<%-- 
    Document   : login
    Created on : 10-Jun-2022, 10:10:18 AM
    Author     : Dakota Chatt
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        
        <form method="post" action="login">
            <label><strong>Username: </strong></label>
            <input type="text" name="username" value="${username}">
            <br>
            <label><strong>Password: </strong></label>
            <input type="password" name="password" value="${password}">
            <br>
            <input type="submit" value="Log in">
        </form>
            
        <c:if test="${message != null}">
            <p style="color: red"><i>${message}</i><p>
        </c:if>
    </body>
</html>
