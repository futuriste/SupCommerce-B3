/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.persistence.dao;

import com.supinfo.supcommerce.entities.Product;
import java.util.List;

/**
 *
 * @author alexis
 */
public interface ProductDao {
    
    public Product findById(final Long id);
    
    public Long add(final Product product);
    
    public List<Product> findAll();
    
    public List<Product> findAllCheaperThan(final Float maxPrice);
    
    public void remove(final Product product);
    
}
