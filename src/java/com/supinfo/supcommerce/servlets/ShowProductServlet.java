/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.servlets;

import com.supinfo.sun.supcommerce.bo.SupProduct;
import com.supinfo.sun.supcommerce.doa.SupProductDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = "/showProduct")
public class ShowProductServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final PrintWriter out = resp.getWriter();
        
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Show product</title>");
        out.println("</head>");
        out.println("<body>");
        try {
            final Long id = Long.parseLong(req.getParameter("id"));
            final SupProduct sp = SupProductDao.findProductById(id);
            
            out.println("<h2>" + sp.getId() + ") " + sp.getName() + " - " + sp.getPrice() + "</h2>");
        }
        catch(NumberFormatException | ArrayIndexOutOfBoundsException ex) {
            out.println("Bad ID");
        }
        finally {
            out.println("</body>");
            out.println("</html>");
        }
        
    }
    
}
