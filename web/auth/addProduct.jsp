<%-- 
    Document   : addProduct
    Created on : 18 nov. 2014, 15:42:44
    Author     : alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a product</title>
    </head>
    <body>
        <%@include file="/partials/header.jsp" %>
        <h1>Add a product</h1>
        
        <form action="/supcommerce/auth/addProduct" method="POST">
            Name : <input type="text" name="productName" placeholder="Product name" /> <br/>
            Content : <textarea name="productContent" placeholder="Product content" cols="10" rows="5"></textarea> <br/>
            Price : <input type="text" name="productPrice" placeholder="0.0" /> <br/>
            <input type="submit" value="Add product" />
        </form>
    </body>
</html>
