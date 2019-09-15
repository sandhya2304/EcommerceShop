package com.shop.OnlineShoppingBackEnd.dao;

import java.util.List;

import com.shop.OnlineShoppingBackEnd.dto.Category;
import com.shop.OnlineShoppingBackEnd.dto.Product;

public interface ProductDao
{
	
	public List<Product> listAll();
	public Product findById(int id);
	
	public boolean saveProduct(Product product);
	public boolean deleteProduct(Product product);
	public boolean updateProduct(Product product);
	
	
	List<Product> listActiveProducts();
	List<Product> listActiveProductsByCategory(int categoryId);
	List<Product> getLatestActiveProduct(int count);
	

}
