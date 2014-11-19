/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.persistence.dao;

import com.supinfo.supcommerce.entities.Category;
import java.util.List;

/**
 *
 * @author alexis
 */
public interface CategoryDao {
    
    public Category findById(final Long id);
    
    public Long add(final Category category);
    
    public List<Category> findAll();
}
