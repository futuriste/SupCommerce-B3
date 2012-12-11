package com.supinfo.supcommerce.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

@WebServlet(urlPatterns = "/listProducts")
public class ListProductsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		List<SupProduct> products = SupProductDao.getAllProducts();
		req.setAttribute("products", products);
		
		RequestDispatcher rd = 
				req.getRequestDispatcher("listProducts.jsp");
		rd.forward(req, resp);
	}

}
