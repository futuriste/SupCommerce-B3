<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<jsp:include page="/template/head.jsp">
			<jsp:param name="pageTitle" value="Ajouter un produit" />
		</jsp:include>
		
		<style type="text/css">
			.form-horizontal { max-width: 500px; }
			.form-horizontal .btn-large { margin-left: auto; margin-right: auto; display: block; }
		</style>
	</head>
	<body>
		<jsp:include page="/template/header.jsp">
			<jsp:param name="currentPage" value="addProduct" />
		</jsp:include>
		
		<div class="container">
			<h1 class="heading">Ajouter un produit</h1>
			
			<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/auth/addProduct">
				<div class="control-group">
				  <label class="control-label" for="inputName">Nom</label>
				  <div class="controls">
				    <input type="text" id="inputName" placeholder="Nom" name="name">
				  </div>
				</div>
				<div class="control-group">
				  <label class="control-label" for="inputContent">Description</label>
				  <div class="controls">
				    <textarea id="inputContent" placeholder="Description" name="content"></textarea>
				  </div>
				</div>
				<div class="control-group">
				  <label class="control-label" for="inputPrice">Prix (€)</label>
				  <div class="controls">
				    <input type="text" id="inputPrice" placeholder="0.0€" name="price">
				  </div>
				</div>
				<input type="submit" class="btn btn-large btn-primary" value="Ajouter le produit" />
			</form>
		</div>
	</body>
</html>