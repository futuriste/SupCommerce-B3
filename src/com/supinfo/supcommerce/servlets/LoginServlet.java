package com.supinfo.supcommerce.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String username = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		if(!username.trim().equals("") && !password.trim().equals("")) {
			HttpSession session = req.getSession();
			session.setAttribute("username", username);
			session.setAttribute("userEmail", email);
			
			resp.sendRedirect(req.getServletContext().getContextPath() + "/listProducts");
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println(req.getSession().getAttribute("username"));
		
		if(req.getSession().getAttribute("username") == null) {	
			RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
			rd.forward(req, resp);
		}
		else {
			resp.sendRedirect(req.getServletContext().getContextPath() + "/listProducts");
		}		
	}

}
