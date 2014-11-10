/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JButton;

/**
 *
 * @author alexis
 */
@WebServlet(urlPatterns = "/listProducts")
public class ListProductServlet extends HttpServlet {

    @Override
    protected void service(final HttpServletRequest req, final HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>List all products</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>List all products</h1>");
        out.println("<ul>");
        
        SupProductDao.getAllProducts().stream()
            .forEach(sp -> out.println("<li>" + sp.getId() + ") " + sp.getName() + " - " + sp.getPrice()));
        
//        for (SupProduct sp : SupProductDao.getAllProducts()) {
//            out.println("<li>" + sp.getId() + ") " + sp.getName() + " - " + sp.getPrice());
//        }
        
        out.println("</ul>");
        out.println("</body>");
        out.println("</html>");
    }
    
}
