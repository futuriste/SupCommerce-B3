package com.supinfo.supcommerce.dao;

import com.supinfo.supcommerce.dao.impl.JpaCategoryDao;
import com.supinfo.supcommerce.dao.impl.NoSQLCategoryDao;

public class DaoFactory {
	
	private DaoFactory() {	}
	
	public static CategoryDao getCategoryDao() {
		return new JpaCategoryDao(PersistenceManager.getEntityManagerFactory());
	}
}
