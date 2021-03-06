/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.persistence;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alexis
 */
public class PersistenceManager {
    
    private static EntityManagerFactory emf;
    
    public static EntityManagerFactory getEntityManagerFactory() {
        if(emf == null)
            emf = Persistence.createEntityManagerFactory("SupCommercePU");

        return emf;
    }
    
    public static void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen())
            emf.close();
    }
    
}
