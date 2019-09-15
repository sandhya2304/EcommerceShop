package com.shop.OnlineShoppingBackEnd.dao;

import java.util.List;

import com.shop.OnlineShoppingBackEnd.dto.Category;



public interface CategoryDao
{

	public List<Category> findAll();
	public Category findById(int id);
	
	public boolean saveCategory(Category category);
	public boolean deleteCategory(Category category);
	public boolean updateCategory(Category category);
	
	

}
