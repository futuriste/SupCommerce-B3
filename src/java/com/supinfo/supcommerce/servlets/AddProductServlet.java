/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.supcommerce.entities.Category;
import com.supinfo.supcommerce.entities.Product;
import com.supinfo.supcommerce.persistence.DaoFactory;
import java.io.IOException;
import java.util.List;
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

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Product product = new Product();
        product.setName(req.getParameter("productName"));
        product.setContent(req.getParameter("productContent"));
        product.setPrice(Float.parseFloat(req.getParameter("productPrice")));
        
        product.setCategory(
            DaoFactory.getCategoryDao().findById(
                Long.parseLong(req.getParameter("categoryId"))
            )
        );
        
        final Long id = DaoFactory.getProductDao().add(product);
        
        resp.sendRedirect(getServletContext().getContextPath() + "/showProduct?id=" + id);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final List<Category> categories = DaoFactory.getCategoryDao().findAll();
        
        req.setAttribute("categories", categories);
        
        req.getRequestDispatcher("/auth/addProduct.jsp").forward(req, resp);
    }
    
}
