package com.supinfo.supcommerce.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import com.supinfo.supcommerce.dao.CategoryDao;
import com.supinfo.supcommerce.entities.Category;

public class JpaCategoryDao implements CategoryDao {

	public EntityManagerFactory emf;
	
	public JpaCategoryDao(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	@Override
	public void addCategory(Category category) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		
		try {
			t.begin();
			
			em.persist(category);
			
			t.commit();
		}
		finally {
			if(t.isActive())
				t.rollback();
			
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAllCategories() {
		List<Category> categories = null;
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery(
			"SELECT c FROM Category c"
		);
		
		categories = query.getResultList();
		
		em.close();
		
		return categories;
	}

}
