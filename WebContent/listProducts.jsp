<%@page import="java.util.List"%>
<%@page import="com.supinfo.sun.supcommerce.bo.SupProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Liste des produits</title>
	</head>
	<body>
		<h1>Liste des produits :</h1>
		
		<a href="<%= request.getServletContext().getContextPath() %>/auth/basicInsert">Ajouter un produit</a>
		<table>
			<tr>
				<th>ID</th>
				<th>Nom</th>
				<th>Prix</th>
				<th>Actions</th>
			</tr>
			<% for(SupProduct sp : (List<SupProduct>) request.getAttribute("products")) { %>
				<tr>
					<td><%= sp.getId() %></td>
					<td><%= sp.getName() %></td>
					<td><%= sp.getPrice() %></td>
					<td><a href="<%= request.getServletContext().getContextPath() %>/showProduct?id=<%= sp.getId() %>">Voir</a></td>
				</tr>	
			<% } %>		
		</table>
	</body>
</html>