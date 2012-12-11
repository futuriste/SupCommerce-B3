<%@page import="java.util.List" %>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="fr">
	<head>
		<jsp:include page="/template/head.jsp">
			<jsp:param name="pageTitle" value="Liste des produits" />
		</jsp:include>
	</head>
	
	<body>
		<jsp:include page="/template/header.jsp">
			<jsp:param name="currentPage" value="listProducts" />
		</jsp:include>
		
		<div class="container">
			<h1 class="heading">Liste des produits :</h1>
			
			<a class="btn btn-info" href="${pageContext.request.contextPath}/auth/addProduct">Ajouter un produit</a>
			<br/><br/>
			
			<table class="table">
				<tr>
					<th>ID</th>
					<th>Nom</th>
					<th>Prix</th>
					<th>Actions</th>
				</tr>

				<c:forEach items="${products}" var="sp">
					<tr>
						<td>${sp.id}</td>
						<td>${sp.name}</td>
						<td>${sp.price} €</td>
						<td><a href="${pageContext.request.contextPath}/showProduct?id=${sp.id}">Voir</a></td>
					</tr>	
				</c:forEach>	
			</table>
		</div>
	</body>
</html>