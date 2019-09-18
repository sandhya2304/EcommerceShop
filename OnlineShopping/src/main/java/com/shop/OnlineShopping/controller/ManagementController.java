package com.shop.OnlineShopping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/manage")
public class ManagementController
{
	@RequestMapping(value="/products")
	public ModelAndView manageProduct()
	{
		ModelAndView mv = new ModelAndView("page");
		
		mv.addObject("title","manage Products");
		mv.addObject("userClickWhenManageProduct",true);
		
		return mv;
	}
	

}
