package com.shop.OnlineShoppingBackEnd.dao;

import java.util.List;

import com.shop.OnlineShoppingBackEnd.dto.Address;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.User;

public interface UserDao
{
	
	boolean addUser(User user);
	
	boolean addAddress(Address address);
	Address getBillingAddress(User user);
	List<Address> listshippingAddress(User user);
	
	
	
	
	User getByEmail(String email);
	
	

}
