package com.shop.OnlineShoppingBackEnd.dao;

import java.util.List;

import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.CartLine;

public interface CartLineDao
{
	
	
	public List<CartLine> listAll(int cartId);
	
	public boolean add(CartLine cartLine);
	
	public boolean update(CartLine cartLine);
	public boolean delete(CartLine cartLine);
	public CartLine get(int id);
	
	boolean updateCart(Cart cart);
	
	
	public List<CartLine> listAvailable(int cartId);
	public CartLine getByCartAndProduct(int cartId,int productId);
	
	
	

}
