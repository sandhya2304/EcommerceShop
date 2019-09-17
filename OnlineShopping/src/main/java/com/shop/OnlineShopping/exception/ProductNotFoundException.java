package com.shop.OnlineShopping.exception;

import java.io.Serializable;

public class ProductNotFoundException extends Exception implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private String message;
	
	
	@Override
	public String getMessage() {
		return super.getMessage();
	}
	
	public ProductNotFoundException() {
		this("Product not found!!!");
	}
	
	public ProductNotFoundException(String msg)
	{
		this.message = System.currentTimeMillis() + ":" +msg;
	}
	

}
