package com.shop.OnlineShoppingBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.OnlineShoppingBackEnd.dao.CartLineDao;
import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dao.UserDao;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.CartLine;
import com.shop.OnlineShoppingBackEnd.dto.Product;
import com.shop.OnlineShoppingBackEnd.dto.User;

public class CartLineTestCase 
{
	
	public static AnnotationConfigApplicationContext context;
	
	private  CartLine cartLine;
	private  Product product;
	private  User user;
	private Cart cart;
	
	
	private static CartLineDao cartLineDao;
	private static ProductDao productDao;
	private static UserDao userDao;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop.OnlineShoppingBackEnd");
		context.refresh();
		
		cartLineDao = (CartLineDao) context.getBean("cartLineDao");
		userDao = (UserDao) context.getBean("userDao");	
		productDao = (ProductDao) context.getBean("productDao");
	}
	
	
	@Test
	public void testAddCartLine()
	{
		
		//get the user
		user= userDao.getByEmail("ram@gmail.com");
		
		//fetch the cart
		cart = user.getCart();
		
		//get the product
		product = productDao.findById(33);
		
		//create a new cartline
		
		cartLine = new CartLine();
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
		cartLine.setCartId(cart.getId());
		
		cartLine.setProduct(product);
		
		assertEquals("cartline failed to add",true,cartLineDao.add(cartLine));
		
		//update the cart
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		cart.setCartLines(cart.getCartLines() + 1);
		
		assertEquals("cartline failed to update",true,cartLineDao.updateCart(cart));
	}
	
	
	
	
	
	

}
