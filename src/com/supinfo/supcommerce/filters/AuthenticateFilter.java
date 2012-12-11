package com.supinfo.supcommerce.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "/auth/*")
public class AuthenticateFilter implements Filter {


	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpReq = (HttpServletRequest) req;
		
		String user = (String) httpReq.getSession()
				.getAttribute("username");
		
		if(user != null) {
			chain.doFilter(req, resp);
		}
		else {
			RequestDispatcher rd = req.getRequestDispatcher("/login");
			rd.forward(req, resp);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	@Override
	public void destroy() {
	}

}
