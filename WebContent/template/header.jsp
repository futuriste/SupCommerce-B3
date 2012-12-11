<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar navbar-fixed-top">
	<div class="navbar-inner">
		<c:if test="${username != null}">
			<div class="gravatarImg">
				<span></span>
				
				<script type="text/javascript">
					$(function() {
						$('.gravatarImg span').append($.gravatar('${userEmail}'));
					});
				</script>
				Bonjour ${username}
			</div>
		</c:if>
		<ul class="nav">
			<c:if test="${username == null}">
				<li class='${param.currentPage.equals("login") ? "active" : ""}'>
					<a href="${pageContext.request.contextPath}/login">Connexion</a>
				</li>
			</c:if>
			<li class='${param.currentPage.equals("listProducts") ? "active" : ""}'>
				<a href="${pageContext.request.contextPath}/listProducts">Lister les produits</a>
			</li>
			<c:if test="${username != null}">
				<li class='${param.currentPage.equals("addProduct") ? "active" : ""}'>
					<a href="${pageContext.request.contextPath}/auth/addProduct">Ajouter un produit</a>
				</li>
			</c:if>
		</ul>
		
		<c:if test="${username != null}">
			<a href="${pageContext.request.contextPath}/logout" class="logoutLink">Déconnexion</a>
		</c:if>
	</div>
</div>