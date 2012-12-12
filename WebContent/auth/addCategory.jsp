<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<jsp:include page="/template/head.jsp">
			<jsp:param name="pageTitle" value="Ajouter une catégorie" />
		</jsp:include>
		
		<style type="text/css">
			.form-horizontal { max-width: 500px; }
			.form-horizontal .btn-large { margin-left: auto; margin-right: auto; display: block; }
		</style>
	</head>
	<body>
		<jsp:include page="/template/header.jsp">
			<jsp:param name="currentPage" value="addCategory" />
		</jsp:include>
		
		<div class="container">
			<h1 class="heading">Ajouter une catégorie</h1>
			
			<form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/auth/addCategory">
				<div class="control-group">
				  <label class="control-label" for="inputName">Nom</label>
				  <div class="controls">
				    <input type="text" id="inputName" placeholder="Nom" name="catName">
				  </div>
				</div>
				<input type="submit" class="btn btn-large btn-primary" value="Ajouter la catégorie" />
			</form>
		</div>
	</body>
</html>