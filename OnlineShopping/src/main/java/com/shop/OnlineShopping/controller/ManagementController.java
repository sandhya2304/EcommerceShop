package com.shop.OnlineShopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.OnlineShoppingBackEnd.dao.CategoryDao;
import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dto.Category;
import com.shop.OnlineShoppingBackEnd.dto.Product;

@Controller
@RequestMapping(value="/manage")
public class ManagementController
{
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private ProductDao productDao;
	
	
	private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);
	
	
	@RequestMapping(value="/products",method = RequestMethod.GET)
	public ModelAndView manageProduct(@RequestParam (name="operation",required = false) 
	                                String operation)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","manage Products");
		mv.addObject("userClickWhenManageProduct",true);
		
		Product nproduct = new Product();
		nproduct.setSupplierId(1);
		nproduct.setActive(true);
		
		mv.addObject("product",nproduct);
		
		
		if(operation!=null)
		{
			if(operation.equals("product"))
			{
				mv.addObject("msg","product submitted successully");
			}
		}
		
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value="/products",method = RequestMethod.POST)
	public String handleProductSubmission(@ModelAttribute ("product") Product mproduct)
	{
		logger.info(mproduct.toString());
		productDao.saveProduct(mproduct);
		
		return "redirect:/manage/products?opertion=product";
	}
	
	
	
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.findAll();
	}

}
