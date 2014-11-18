<%-- 
    Document   : showProduct
    Created on : 18 nov. 2014, 15:38:15
    Author     : alexis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${product.name}</title>
    </head>
    <body>
        <%@include file="/partials/header.jsp" %>
        <br/><br/>
        <h1>${product.id}) ${product.name} - ${product.price}</h1>
    </body>
</html>
