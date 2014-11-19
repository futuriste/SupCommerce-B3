/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.entities.Product;
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

/**
 *
 * @author alexis
 */
@WebServlet(urlPatterns = "/auth/addProduct")
public class AddProductServlet extends HttpServlet {
    
    private EntityManagerFactory emf;

    @Override
    public void init() throws ServletException {
        super.init();
        
        emf = Persistence.createEntityManagerFactory("SupCommercePU");
    }

    @Override
    public void destroy() {
        super.destroy();
        
        emf.close();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Product product = new Product();
        product.setName(req.getParameter("productName"));
        product.setContent(req.getParameter("productContent"));
        product.setPrice(Float.parseFloat(req.getParameter("productPrice")));
        
        EntityManager em = emf.createEntityManager();
        EntityTransaction t = em.getTransaction();
        
        try {
            t.begin();
            
            em.persist(product);
            
            t.commit();
        }
        finally {
            if(t.isActive())
                t.rollback();
            
            em.close();
        }
        
        resp.sendRedirect(getServletContext().getContextPath() + "/showProduct?id=" + product.getId());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth/addProduct.jsp").forward(req, resp);
    }
    
}
