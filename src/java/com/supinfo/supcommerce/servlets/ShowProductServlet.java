/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import com.supinfo.supcommerce.entities.Product;
import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
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
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {
    
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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        try {
            final Long id = Long.parseLong(req.getParameter("id"));
            
            EntityManager em = emf.createEntityManager();
            
            System.out.println("id : " + id);
            final Product p = em.find(Product.class, id);
            
            System.out.println("product : " + p);
            
            em.close();
            
            req.setAttribute("product", p);
            
            req.getRequestDispatcher("/showProduct.jsp").forward(req, resp);
        }
        catch(Exception ex) {
            
        }
        
    }
    
}
