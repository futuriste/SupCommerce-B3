package com.supinfo.supcommerce.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceManager {

	private static EntityManagerFactory emf;
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("SupCommercePU");
		}
		
		return emf;
	}
	
	public static void closeEntityManagerFactory() {
		if(emf != null && emf.isOpen())
			emf.close();
	}
}
