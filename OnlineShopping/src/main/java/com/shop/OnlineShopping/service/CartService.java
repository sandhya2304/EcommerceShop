package com.shop.OnlineShopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.OnlineShopping.model.UserModel;
import com.shop.OnlineShoppingBackEnd.dao.CartLineDao;
import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.CartLine;
import com.shop.OnlineShoppingBackEnd.dto.Product;

@Service("cartService")
public class CartService
{
	@Autowired
	CartLineDao cartLineDao;
	
	@Autowired
	HttpSession httpSession;
	
	
	@Autowired
	ProductDao productDao;
	
	
	private Cart getCart()
	{
		return ((UserModel)httpSession.getAttribute("userModel")).getCart();	
	}
	
	
	public List<CartLine> getCartLines()
	{
		Cart cart = this.getCart();
		return cartLineDao.listAll(cart.getId());
	}


	public String manageCartLine(int cartLineId, int count)
	{
		//fetch the cartline 
		
		CartLine cartline = cartLineDao.get(cartLineId);
		
		
		if(cartline==null)
		{
			return "result=error";
		}else
		{
			Product product = cartline.getProduct();
			double oldTotal = cartline.getTotal();
			
			
			
			if(product.getQuantity() < count)
			{
				return "result=unavailable";
			}
			
			
			
			cartline.setProductCount(count);
			cartline.setBuyingPrice(product.getUnitPrice());
			
			cartline.setTotal(product.getUnitPrice() * count);
			
			cartLineDao.update(cartline);
			
			Cart cart = this.getCart();
			
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal +cartline.getTotal());
		
			cartLineDao.updateCart(cart);
			
		}
		
		return "result=updated";
	}


	public String deleteCartLine(int cartLineId) 
	{
		CartLine cartline = cartLineDao.get(cartLineId);
		
		if(cartline==null)
		{
			return "result=error";
		}else
		{
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - cartline.getTotal());
			cart.setCartLines(cart.getCartLines() - 1);
			
			cartLineDao.updateCart(cart);
			
			cartLineDao.delete(cartline);
			
			return "result=deleted";
		}
	
	}


	public String addCartLine(int productId)
	{
		String response = null;
		
		Cart cart = this.getCart();
		
		CartLine cartLine = cartLineDao.getByCartAndProduct(cart.getId(), productId);
		
		if(cartLine == null)
		{
			cartLine  = new CartLine();
			Product product = productDao.findById(productId);
			cartLine.setCartId(cart.getId());
			
			
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			
			
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			
			
			cartLineDao.add(cartLine);
			
			
			cart.setCartLines(cart.getCartLines() + 1);
			
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			
			cartLineDao.updateCart(cart);
			
			
			response = "result=added";
			
		}else
		{
			if(cartLine.getProductCount() < 3)
			{
				
				response = this.manageCartLine(cartLine.getId(),cartLine.getProductCount() +1);
				
			}else
			{
				response = "result=maximium";
			}
			
			
		}
		
		return response;
	}
	
	
	
	
	
	

}
