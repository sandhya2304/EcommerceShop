package com.shop.OnlineShopping.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.shop.OnlineShoppingBackEnd.dto.Product;



public class ProductValidator implements Validator
{

	@Override
	public boolean supports(Class<?> clazz) {
	
		//check instance
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		Product product = (Product) target;
		
		if(product.getFile() == null || 
				product.getFile().getOriginalFilename().equals(""))
		{
			errors.rejectValue("file",null,"PLEASE SELECT AN IMAGE TO UPLOAD");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/jpeg")||
				!product.getFile().getContentType().equals("image/png")||	
				!product.getFile().getContentType().equals("image/gif")
				))
		{
			//field,code,msg
			errors.rejectValue("file",null,"PLEASE SELECT AN RIGHT IMAGE TO UPLOAD");
			return;
		}
		
	}

	
}
