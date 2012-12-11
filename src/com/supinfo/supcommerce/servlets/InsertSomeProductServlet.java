package com.supinfo.supcommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

@WebServlet(urlPatterns = "/auth/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, IOException {
		
		SupProduct product = new SupProduct();
		product.setName("Toto product");
		product.setContent("Mon beau contenu");
		product.setPrice(10.0f);
		
		SupProductDao.addProduct(product);
		
		resp.sendRedirect(req.getServletContext().getContextPath() + "/listProducts");
	}

	
}





