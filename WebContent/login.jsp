<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html lang="fr">
	<head>
		<jsp:include page="/template/head.jsp">
			<jsp:param name="pageTitle" value="Connexion" />
		</jsp:include>
		
		<style type="text/css">
			.form-signin {
				max-width: 300px;
				padding: 19px 29px 29px;
				margin: 0 auto 20px;
				background-color: white;
				border: 1px solid #E5E5E5;
				-webkit-border-radius: 5px;
				-moz-border-radius: 5px;
				border-radius: 5px;
				-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
				-moz-box-shadow: 0 1px 2px rgba(0,0,0,.05);
				box-shadow: 0 1px 2px rgba(0, 0, 0, .05);
			}
			
			.form-signin .btn { display: block; margin: 10px auto 0px auto; }
		</style>
	</head>
	
	<body>
		<jsp:include page="/template/header.jsp">
			<jsp:param name="currentPage" value="login" />
		</jsp:include>
		
		<c:if test="${username != null}">
			<jsp:forward page="/listProducts" />
		</c:if>
		
		<div class="container">
			<form class="form-signin" method="post" action="/SupCommerce/login">
				<h2 class="heading">Connexion</h2>
				<input type="text" name="username" class="input-block-level" placeholder="Identifiant" />
				<input type="text" name="email" class="input-block-level" placeholder="Adresse email" />
				<input type="password" name="password" class="input-block-level" placeholder="Mot de passe" />
				<input class="btn btn-large btn-primary" type="submit" value="Connexion" />
			</form>
		</div>
	</body>
</html>