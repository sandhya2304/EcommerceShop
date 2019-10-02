package com.shop.OnlineShopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.shop.OnlineShopping.model.UserModel;
import com.shop.OnlineShoppingBackEnd.dao.UserDao;
import com.shop.OnlineShoppingBackEnd.dto.User;

@ControllerAdvice
public class GlobalController 
{
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	UserDao userDao;
	
	UserModel userModel;
	
	
	@ModelAttribute("userModel")
	public UserModel getUserModel()
	{
		
		if(httpSession.getAttribute("userModel") == null)
		{
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			User user= userDao.getByEmail(authentication.getName());
			if(user!=null)
			{
				
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setEmail(user.getEmail());
				userModel.setRole(user.getRole());
				userModel.setFullname(user.getFirstName()+" "+user.getLastName());
				
				
				if(userModel.getRole().equals("USER"))
				{
					userModel.setCart(user.getCart());
				}
				
				httpSession.setAttribute("userModel",userModel);
				return userModel;
			}
			
			
		}
		
		return (UserModel) httpSession.getAttribute("userModel");
	}
	

}
