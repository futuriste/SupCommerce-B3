/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.persistence.dao.impl;

import com.supinfo.supcommerce.entities.Category;
import com.supinfo.supcommerce.persistence.JpaDaoUtils;
import com.supinfo.supcommerce.persistence.dao.CategoryDao;
import java.util.List;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author alexis
 */
public class JpaCategoryDao extends JpaDaoUtils implements CategoryDao {
    
    public JpaCategoryDao(final EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Category findById(final Long id) {
        return emf.createEntityManager().find(Category.class, id);
    }

    @Override
    public Long add(final Category category) {
        return withTransaction(em -> {
            em.persist(category);
            return category.getId();
        });
    }

    @Override
    public List<Category> findAll() {
        return emf.createEntityManager().createNamedQuery("findAllCategories").getResultList();
    }
    
}
