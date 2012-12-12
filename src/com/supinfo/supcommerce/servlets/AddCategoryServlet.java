package com.supinfo.supcommerce.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcommerce.entities.Category;

@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EntityManagerFactory emf;
	
	@Override
	public void init() throws ServletException {
		super.init();
		
		emf = Persistence.createEntityManagerFactory("SupCommercePU");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addCategory.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Category category = new Category();
		category.setName(req.getParameter("catName"));
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			
			em.persist(category);
			
			t.commit();
			
			req.setAttribute("message-ok", "Catégorie correctement ajoutée");
		}
		catch(Exception e) {
			req.setAttribute("message-error", "Problème lors de l'ajout de la catégorie");
		}
		finally {
			if(t.isActive())
				t.rollback();
			
			em.close();
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("/auth/addCategory.jsp");
		rd.forward(req, resp);
	}

	@Override
	public void destroy() {
		emf.close();
		
		super.destroy();
	}

}
