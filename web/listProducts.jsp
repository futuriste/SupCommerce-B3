<%-- 
    Document   : listProducts
    Created on : 18 nov. 2014, 10:00:55
    Author     : alexis
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="java.util.stream.Stream"%>
<%@page import="com.supinfo.sun.supcommerce.doa.SupProductDao"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List products</title>
    </head>
    <body>
        <%@include file="/partials/header.jsp" %>
        
        <br/><br/>
        Hello list products !
        
        <ul>
            <c:forEach items="${products}" var="sp">
                <li>${sp.id}) ${sp.name} - ${sp.price}</li>
            </c:forEach>
        </ul>
    </body>
</html>
