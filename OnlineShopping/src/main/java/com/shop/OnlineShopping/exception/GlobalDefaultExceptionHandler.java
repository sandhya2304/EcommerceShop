package com.shop.OnlineShopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler 
{
	
	//if we write anything in url this error
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNoHandlerFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","This page is not constructed!!");
		mv.addObject("errorDescription","The page your are looking not available now!!!");
		mv.addObject("title","404 Error Page");
		
		return mv;
	}
	
	
	//custom exception if digit someone finding product
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException()
	{
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","This product is not available!!");
		mv.addObject("errorDescription","The product your are looking not available now!!!");
		mv.addObject("title","Product not avail");
		
		return mv;
	}
	
	
     //generalize exception if somebody write string in url
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex)
	{
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","ERROR !!");
		mv.addObject("errorDescription",ex.toString());
		mv.addObject("title","Error");
		
		return mv;
	}
	
	

}
