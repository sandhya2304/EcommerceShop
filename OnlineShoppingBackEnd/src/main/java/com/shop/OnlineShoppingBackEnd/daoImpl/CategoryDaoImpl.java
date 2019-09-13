package com.shop.OnlineShoppingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.shop.OnlineShoppingBackEnd.dao.CategoryDao;
import com.shop.OnlineShoppingBackEnd.dto.Category;


@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
	
	static List<Category> categories = new ArrayList<Category>();	
	
	static
	{
		Category c = new Category(1, "food", "food de do", "foodimg.jpg",true);
		Category c1 = new Category(2, "cloth", "cloth de do", "clothfoodimg.jpg",true);
		
		categories.add(c);
		categories.add(c1);
	}
	
	@Override
	public List<Category> findAll() 
	{	
		return categories;
	}

	@Override
	public Category findById(int id) {
		for(Category category :categories )
		{
			if(category.getId()==id)
			{
				return category;
			}
		}
		return null;
	}

	@Override
	public void saveCategory(Category category) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCategory(Category category) {
		// TODO Auto-generated method stub
		
	}
	
	

}
