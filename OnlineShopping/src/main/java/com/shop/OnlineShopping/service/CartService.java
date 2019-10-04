package com.shop.OnlineShopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.OnlineShopping.model.UserModel;
import com.shop.OnlineShoppingBackEnd.dao.CartLineDao;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.CartLine;

@Service("cartService")
public class CartService
{
	@Autowired
	CartLineDao cartLineDao;
	
	@Autowired
	HttpSession httpSession;
	
	
	private Cart getCart()
	{
		return ((UserModel)httpSession.getAttribute("userModel")).getCart();	
	}
	
	
	public List<CartLine> getCartLines()
	{
		Cart cart = this.getCart();
		return cartLineDao.listAll(cart.getId());
	}
	
	
	
	
	
	

}
