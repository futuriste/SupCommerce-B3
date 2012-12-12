package com.supinfo.supcommerce.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.entities.Category;

@WebServlet(urlPatterns = "/basicInsert")
public class InsertSomeProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactory emf;

	@Override
	public void init() throws ServletException {
		super.init();
		
		emf = Persistence.createEntityManagerFactory("SupCommercePU");
	}

	@Override
	protected void service(HttpServletRequest req, 
			HttpServletResponse resp)
			throws ServletException, IOException {
		
		Category category = new Category();
		category.setName("Test Category");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			
			em.persist(category);
			
			t.commit();
		}
		finally {
			if(t.isActive())
				t.rollback();
			
			em.close();
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		
		emf.close();
	}
}





