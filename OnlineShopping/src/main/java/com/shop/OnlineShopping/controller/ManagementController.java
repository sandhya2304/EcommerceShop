package com.shop.OnlineShopping.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shop.OnlineShopping.util.fileUploadUtility;
import com.shop.OnlineShopping.validator.ProductValidator;
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
	public String handleProductSubmission(@Valid @ModelAttribute ("product") Product mproduct,
			 BindingResult results,Model model,HttpServletRequest request)
	{
		
		new ProductValidator().validate(mproduct, results);
		
		
		if(results.hasErrors())
		{
			model.addAttribute("title","manage Products");
			model.addAttribute("userClickWhenManageProduct",true);
			model.addAttribute("msg","validation failed for Product submission!!!");
			
			return "page";
		}
		
		//for debugging
		logger.info(mproduct.toString());
		productDao.saveProduct(mproduct);
		
		if(!mproduct.getFile().getOriginalFilename().equals(""))
		{
			fileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	
	//show all categories
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.findAll();
	}

}
