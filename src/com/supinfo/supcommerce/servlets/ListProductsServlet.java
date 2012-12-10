package com.supinfo.supcommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

@WebServlet(urlPatterns = "/auth/listProducts")
public class ListProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<SupProduct> products = SupProductDao.getAllProducts();
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>" +
				"<title>List Products</title>" +
				"<meta charset='utf-8'>" +
				"</head>");
		out.println("<body>");
		out.println("<h1>Liste des produits : " + req.getAttribute("test") + "</h1>");
		out.println("<table>");
		out.println("<tr><th>ID</th><th>Nom</th><th>Prix (€)</th><th>Action</th></tr>");
		
		for(SupProduct p : products) {
			out.println("<tr>");
			out.println("<td>" + p.getId() + "</td>");
			out.println("<td>" + p.getName() + "</td>");
			out.println("<td>" + p.getPrice() + "</td>");
			out.println("<td><a href='" + req.getServletContext().getContextPath() + "/auth/showProduct?id=" + p.getId() + "'>Voir</a></td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br/><a href='" + req.getServletContext().getContextPath() + "/auth/basicInsert'>Ajouter un produit</a>");
		out.println("</body>");
	}

}
