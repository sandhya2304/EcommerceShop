package com.shop.OnlineShoppingBackEnd.dao;

import java.util.List;

import com.shop.OnlineShoppingBackEnd.dto.Category;



public interface CategoryDao
{

	public List<Category> findAll();
	public Category findById(int id);
	
	public void saveCategory(Category category);
	public void deleteCategory(int id);
	public void updateCategory(Category category);
	
	

}
