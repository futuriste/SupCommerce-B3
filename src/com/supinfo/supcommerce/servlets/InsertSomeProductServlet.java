package com.supinfo.supcommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

public class InsertSomeProductServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, IOException {
		
		SupProduct product = new SupProduct();
		product.setName("Toto product");
		product.setContent("Mon beau contenu");
		product.setPrice(10.0f);
		
		SupProductDao.addProduct(product);
		
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		out.println("<html>");
		out.println("<head>" +
				"<title>Add Product</title>" +
				"<meta charset='utf-8'>" +
				"</head>");
		out.println("<body>");
		out.println("<p>Produit ajouté !</p>");
		out.println("</body>");
	}

	
}
