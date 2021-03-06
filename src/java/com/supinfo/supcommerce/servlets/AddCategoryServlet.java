/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.supcommerce.entities.Category;
import com.supinfo.supcommerce.persistence.DaoFactory;
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
@WebServlet(urlPatterns = "/auth/addCategory")
public class AddCategoryServlet extends HttpServlet {    

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final String categoryName = req.getParameter("name");
        
        final Category category = new Category();
        category.setName(categoryName);
        
        DaoFactory.getCategoryDao().add(category);
        
        req.getRequestDispatcher("/auth/addCategory.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/auth/addCategory.jsp").forward(req, resp);
    }
    
}
