package com.supinfo.supcommerce.dao;

import java.util.List;

import com.supinfo.supcommerce.entities.Category;

public interface CategoryDao {

	public void addCategory(Category category);
	
	public List<Category> getAllCategories();
}
