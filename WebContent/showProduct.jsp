<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/template/head.jsp">
			<jsp:param name="pageTitle" value="Détails produit" />
		</jsp:include>
		
		<style type="text/css">
			.productDetails { line-height: 30px; font-size: 1.2em; }
		</style>
	</head>
	<body>
		<jsp:include page="/template/header.jsp">
			<jsp:param name="currentPage" value="showProduct" />
		</jsp:include>
		
		<div class="container productDetails">
			<h1 class="heading">Produit n°${product.id}</h1>
			
			<div class="row">
				<span class="span2"><b>Nom</b></span>
				<span class="span5 offset1">${product.name}</span>
			</div>
			<div class="row">
				<span class="span2"><b>Description</b></span>
				<span class="span5 offset1">${product.content}</span>
			</div>
			<div class="row">
				<span class="span2"><b>Prix</b></span>
				<span class="span5 offset1">${product.price}</span>
			</div>
		</div>
	</body>
</html>