package com.shop.OnlineShopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.shop.OnlineShoppingBackEnd.dao.CategoryDao;
import com.shop.OnlineShoppingBackEnd.dto.Category;

@Controller
public class PageController
{
	@Autowired
	private CategoryDao categoryDao;
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","Home");
		mv.addObject("categories",categoryDao.findAll());
		mv.addObject("userClickHome",true);
		return mv;
	}

	
	@RequestMapping(value="/about")
	public ModelAndView about()
	{
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","About Us");
		mv.addObject("userClickAbout",true);
		return mv;
	}

	@RequestMapping(value="/contact")
	public ModelAndView contact()
	{
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("contact","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
/**
 * method to load all products based on category
 * 	
 * @return
 */
	
	@RequestMapping(value= "/show/all/products")
	public ModelAndView allProducts()
	{
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","All Products");
		mv.addObject("categories",categoryDao.findAll());
		mv.addObject("userClickAllProducts",true);
		return mv;
	}
	
	@RequestMapping(value= "/show/category/{id}/products")
	public ModelAndView allProductsbyCatgeory(@PathVariable int id)
	{
		ModelAndView mv  = new ModelAndView("page");
		
		Category c = null;
		
		c = categoryDao.findById(id);
		
		mv.addObject("title",c.getName());
		mv.addObject("categories",categoryDao.findAll());
		
		mv.addObject("category",c);
		
		mv.addObject("userClickCategoryProducts",true);
		
		return mv;
	}


	
}
