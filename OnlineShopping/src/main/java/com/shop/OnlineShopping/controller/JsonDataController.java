package com.shop.OnlineShopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dto.Product;



@Controller
@RequestMapping(value="/json/data")
public class JsonDataController
{
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping(value="/all/Products")
	@ResponseBody
	public List<Product> listAllProduct()
	{
		return productDao.listActiveProducts();
	}
	
	
	@RequestMapping(value="/category/{id}/Products")
	@ResponseBody
	public List<Product> getProductByCategory(@PathVariable int id)
	{
		return productDao.listActiveProductsByCategory(id);
	}
	

}
