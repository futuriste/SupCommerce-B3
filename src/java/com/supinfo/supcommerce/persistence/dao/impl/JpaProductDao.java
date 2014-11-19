/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.supcommerce.persistence.dao.impl;

import com.supinfo.supcommerce.entities.Product;
import com.supinfo.supcommerce.persistence.JpaDaoUtils;
import com.supinfo.supcommerce.persistence.dao.ProductDao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

/**
 *
 * @author alexis
 */
public class JpaProductDao extends JpaDaoUtils implements ProductDao {

    public JpaProductDao(final EntityManagerFactory emf) {
        super(emf);
    }

    @Override
    public Product findById(final Long id) {
        final EntityManager em = emf.createEntityManager();
        
        return em.find(Product.class, id);
    }
    
    @Override
    public Long add(final Product product) {
        return withTransaction(em -> {
            em.persist(product);
            
            return product.getId();
        });
    }

    @Override
    public List<Product> findAll() {
        final EntityManager em = emf.createEntityManager();
        
        return em.createNamedQuery("findAllProducts").getResultList();
    }

    @Override
    public List<Product> findAllCheaperThan(final Float maxPrice) {
        
        System.out.println("maxPrice : " + maxPrice);
        final EntityManager em = emf.createEntityManager();
        final Query q = em.createNamedQuery("findAllProductsCheaperThan");
        q.setParameter("maxPrice", maxPrice);
        
        return q.getResultList();
    }

    @Override
    public void remove(Product product) {
        withTransaction(em -> {
            em.remove(product);
            return true;
        });
    }
    
}
