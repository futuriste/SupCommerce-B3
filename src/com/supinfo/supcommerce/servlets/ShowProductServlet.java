package com.supinfo.supcommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

/**
 * Servlet implementation class ShowProductServlet
 */
@WebServlet("/showProduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		SupProduct product = SupProductDao.findProductById(id);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>" +
				"<title>Show Product</title>" +
				"<meta charset='utf-8'>" +
				"</head>");
		out.println("<body>");
		out.println("<h1>Détails du produit n°" + id + " :</h1>");
		out.println("<b>Nom :</b> " + product.getName());
		out.println("<br/><b>Description :</b>" + product.getContent());
		out.println("<br/><b>Prix (€) :</b> " + product.getPrice());
		out.println("</body>");
	}

}
