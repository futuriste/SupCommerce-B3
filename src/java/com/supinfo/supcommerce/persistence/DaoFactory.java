/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.persistence;

import com.supinfo.supcommerce.persistence.dao.CategoryDao;
import com.supinfo.supcommerce.persistence.dao.ProductDao;
import com.supinfo.supcommerce.persistence.dao.impl.JpaCategoryDao;
import com.supinfo.supcommerce.persistence.dao.impl.JpaProductDao;

/**
 *
 * @author alexis
 */
public class DaoFactory {
    
    private DaoFactory() {}
    
    public static ProductDao getProductDao() {
        return new JpaProductDao(PersistenceManager.getEntityManagerFactory());
    }
    
    public static CategoryDao getCategoryDao() {
        return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
    }
}
