package com.shop.OnlineShopping.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.OnlineShopping.exception.ProductNotFoundException;
import com.shop.OnlineShoppingBackEnd.dao.CategoryDao;
import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dto.Category;
import com.shop.OnlineShoppingBackEnd.dto.Product;

@Controller
public class PageController
{
	
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	@Autowired
	private ProductDao productDao;
	
	
	@RequestMapping(value= {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("inside pagecontroller index method--info");
		logger.debug("inside pagecontroller index method--debug");
		
		
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
		mv.addObject("title","Contact");
		mv.addObject("userClickContact",true);
		return mv;
	}
	
	@RequestMapping(value="/register")
	public ModelAndView register()
	{
		ModelAndView mv  = new ModelAndView("page");
		mv.addObject("title","register");
		
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
	
	/*
	 * view single PRoduct
	 * 
	 */
	@RequestMapping(value= "/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable int id) throws ProductNotFoundException
	{
		ModelAndView mv = new ModelAndView("page");
		Product product = productDao.findById(id);
		
		if(product == null)
		{
			throw new ProductNotFoundException();
		}
		
		//update view count
		product.setViews(product.getViews()+1);
		
		productDao.updateProduct(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product); //for display
		
		mv.addObject("userClickShowSingleProduct",true);//for master page
		
		return mv;
	}
	
	
	@RequestMapping(value="/login")
	public ModelAndView login(@RequestParam(name="error",required=false)String error)
	{
		ModelAndView mv  = new ModelAndView("login");
		if(error!=null)
		{
			mv.addObject("msg","invalid username and passwrod");
		}
		
		mv.addObject("title","Login Us");
	
		return mv;
	}
	
	
	
	@RequestMapping(value="/access-denied")
	public ModelAndView accessDenied()
	{
		ModelAndView mv  = new ModelAndView("error");
		
		mv.addObject("title","403 - Access denied");
		mv.addObject("errorTitle"," Access denied");
		mv.addObject("errorDescription","Not Authorize");
		
		return mv;
	}




	
}
