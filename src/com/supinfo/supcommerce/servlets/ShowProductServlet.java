package com.supinfo.supcommerce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;

@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		Long id = Long.valueOf(req.getParameter("id"));
		SupProduct product = SupProductDao.findProductById(id);
		
		req.setAttribute("product", product);
		
		RequestDispatcher rd = req.getRequestDispatcher("/showProduct.jsp");
		rd.forward(req, resp);
	}

}
