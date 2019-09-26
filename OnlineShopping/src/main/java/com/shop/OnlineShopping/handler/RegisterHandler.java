package com.shop.OnlineShopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.shop.OnlineShopping.model.RegisterModel;
import com.shop.OnlineShoppingBackEnd.dao.UserDao;
import com.shop.OnlineShoppingBackEnd.dto.Address;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.User;

@Component
public class RegisterHandler
{
	
	 @Autowired
	 private UserDao userDAO;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	
	public void addUser(RegisterModel registerModel,User user)
	{
		registerModel.setUser(user);
	}
	
	
	public void addBilling(RegisterModel registerModel,Address address)
	{
		registerModel.setBilling(address);
	}
	
	 public String saveAll(RegisterModel registerModel) {
		  String transitionValue = "success";
		  User user = registerModel.getUser();
		  if(user.getRole().equals("USER")) {
		   // create a new cart
		   Cart cart = new Cart();
		   cart.setUser(user);
		   user.setCart(cart);
		  }
		   
		  // encode the password
		  ///user.setPassword(passwordEncoder.encode(user.getPassword()));
		  
		  // save the user
		  userDAO.addUser(user);
		  // save the billing address
		  Address billing = registerModel.getBilling();
		  billing.setUser(user);
		  billing.setBilling(true);  
		  userDAO.addAddress(billing);
		  return transitionValue ;
		 } 
	
	

}
