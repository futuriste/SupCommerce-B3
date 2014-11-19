<%-- 
    Document   : addCategory
    Created on : 19 nov. 2014, 09:31:34
    Author     : alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a category</title>
    </head>
    <body>
        <%@include file="/partials/header.jsp" %>
        <h1>Add a category</h1>
        
        <form action="/supcommerce/auth/addCategory" method="POST">
            <input type="text" name="name" placeholder="Category name" /> <br/>
            <input type="submit" value="Create category" />
        </form> 
    </body>
</html>
