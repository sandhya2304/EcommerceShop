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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
			else if(operation.equals("category"))
			{
				mv.addObject("msg","category submitted successully");
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value="/{id}/product",method = RequestMethod.GET)
	public ModelAndView manageEditProduct(@PathVariable int id)
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","manage Products");
		mv.addObject("userClickWhenManageProduct",true);
		
		Product nproduct = productDao.findById(id);
		
		mv.addObject("product",nproduct);
		
		
		
		
		return mv;
	}
	
	//handling product submission
	@RequestMapping(value="/products",method = RequestMethod.POST)
	public String handleProductSubmission(@Valid @ModelAttribute ("product") Product mproduct,
			 BindingResult results,Model model,HttpServletRequest request)
	{
		
		if(mproduct.getId() == 0)
		{
		  new ProductValidator().validate(mproduct, results);
		}else
		{
			if(!mproduct.getFile().getOriginalFilename().equals("") )
			{
				 new ProductValidator().validate(mproduct, results);
			}
		}
		
		if(results.hasErrors())
		{
			model.addAttribute("title","manage Products");
			model.addAttribute("userClickWhenManageProduct",true);
			model.addAttribute("msg","validation failed for Product submission!!!");
			
			return "page";
		}
		
		//for debugging
		logger.info(mproduct.toString());
		
		
		if(mproduct.getId() == 0)
		{
			productDao.saveProduct(mproduct);
		}else
		{
			productDao.updateProduct(mproduct);
		}
		
		
		
		if(!mproduct.getFile().getOriginalFilename().equals(""))
		{
			fileUploadUtility.uploadFile(request,mproduct.getFile(),mproduct.getCode());
		}
		
		
		return "redirect:/manage/products?operation=product";
	}
	
	//activation and deactivation product
	@RequestMapping(value="/product/{id}/activation",method = RequestMethod.POST)
	@ResponseBody
	public String handleActivationProduct(@PathVariable int id)
	{
		//fetch product from db
		Product product = productDao.findById(id);
		
		//
		boolean isActive = product.isActive();
		//activeate and deactivete based on field
		product.setActive(!product.isActive());
		
		productDao.updateProduct(product);
		
		return (isActive)? "you have succesfully deactivate the product with id"+product.getId():
			            "you have succesfully activate the product with id"+product.getId();
	}
	
	
	@RequestMapping(value="/category",method = RequestMethod.POST)
	public String handleCategorySubmit(@ModelAttribute Category category)
	{
		
		categoryDao.saveCategory(category);
		
		return "redirect:/manage/products?operation=category";
		
	}
	
	
	//show all categories
	@ModelAttribute("categories")
	public List<Category> getCategories()
	{
		return categoryDao.findAll();
	}
	
	@ModelAttribute("category")
	public Category getCategory()
	{
		return new Category();
	}

}
