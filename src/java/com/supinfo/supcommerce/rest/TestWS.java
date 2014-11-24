/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.rest;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author alexis
 */
@Path("/test")
public class TestWS {
    
    @GET
    public String testGet() {
        return "Hello from JAX-RS !";
    }
    
    
    @POST
    @Path("/{toto}")
    public String testPost(@PathParam("toto") String toto) {
        return "Hello " + toto;
    }
    
}
