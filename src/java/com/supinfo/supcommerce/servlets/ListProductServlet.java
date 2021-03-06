/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

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
@WebServlet(urlPatterns = "/listProducts")
public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final List<Product> products = DaoFactory.getProductDao().findAll();
        
        req.setAttribute("products", products);
        
        req.getRequestDispatcher("/listProducts.jsp").forward(req, resp);
    }
    
}
