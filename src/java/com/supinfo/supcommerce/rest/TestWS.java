/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.rest;

import com.supinfo.supcommerce.entities.Product;
import com.supinfo.supcommerce.persistence.DaoFactory;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author alexis
 */
@Path("/test")
public class TestWS {
    
    @GET
    public List<Product> testProducts() {
        return DaoFactory.getProductDao().findAll();
    }
    
    
    @POST
    @Path("/{toto}")
    public String testPost(@PathParam("toto") String toto) {
        return "Hello " + toto;
    }
    
}
