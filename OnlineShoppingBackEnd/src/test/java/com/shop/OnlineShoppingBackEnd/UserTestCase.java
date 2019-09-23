package com.shop.OnlineShoppingBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.OnlineShoppingBackEnd.dao.UserDao;
import com.shop.OnlineShoppingBackEnd.dto.Address;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.User;

public class UserTestCase
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDao userDao;
	
	private Address address =null;
	
	private Cart cart = null;;
	
	private  User user = null;;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop.OnlineShoppingBackEnd");
		context.refresh();
		
		userDao = (UserDao) context.getBean("userDao");	
	}
	
	/*@Test
	public void testUser()
	{
		
		user = new User() ;
		user.setFirstName("sandhya");
		user.setLastName("sharma");
		user.setEmail("ss@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setEnabled(true);
		user.setPassword("12345");
		
		
	   assertEquals("failed user added ", true,userDao.addUser(user));
		
		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);
		
		address.setUserId(user.getId());
		
		assertEquals("failed to address added in cart", true,userDao.addAddress(address));
		
		
		if(user.getRole().equals("USER"))
		{
			//create cart for this user
			
			cart = new Cart();
			cart.setUser(user);
			
			assertEquals("failed to  add  cart", true,userDao.addCart(cart));
			//link shipping address
			
			// add the shipping address
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
		   
			address.setShipping(true);
			
			address.setUserId(user.getId());
			
			
			assertEquals("Failed to add the shipping address!", true, userDao.addAddress(address));
			
			
		}
		*/
	
	/*
	 * @Test public void testUser() {
	 * 
	 * user = new User() ; user.setFirstName("sandhya"); user.setLastName("sharma");
	 * user.setEmail("ss@gmail.com"); user.setContactNumber("1234512345");
	 * user.setRole("USER"); user.setEnabled(true); user.setPassword("12345");
	 * 
	 * 
	 * 
	 * if(user.getRole().equals("USER")) { //create cart for this user
	 * 
	 * cart = new Cart(); cart.setUser(user);
	 * 
	 * //attach cart with the user
	 * 
	 * user.setCart(cart);
	 * 
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 * 
	 * assertEquals("failed user added ", true,userDao.addUser(user)); }
	 */
	
	/*
	 * @Test public void testUpdateUser() { user =
	 * userDao.getByEmail("ss@gmail.com");
	 * 
	 * cart = user.getCart(); cart.setGrandTotal(1344); cart.setCartLines(2);
	 * 
	 * 
	 * assertEquals("failed to update cart  ", true,userDao.updateCart(cart)); }
	 * 
	 */
	
	/*
	 * @Test public void testAddress() {
	 * 
	 * 
	 * user = new User() ; user.setFirstName("sandhya"); user.setLastName("sharma");
	 * user.setEmail("ss@gmail.com"); user.setContactNumber("1234512345");
	 * user.setRole("USER"); user.setEnabled(true); user.setPassword("12345");
	 * 
	 * 
	 * assertEquals("failed user added ", true,userDao.addUser(user));
	 * 
	 * address = new Address();
	 * address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
	 * address.setAddressLineTwo("Near Kaabil Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("400001"); address.setBilling(true);
	 * 
	 * address.setUser(user);
	 * 
	 * assertEquals("failed to address added in cart",
	 * true,userDao.addAddress(address));
	 * 
	 * // add the shipping address address = new Address();
	 * address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
	 * address.setAddressLineTwo("Near Kudrat Store"); address.setCity("Mumbai");
	 * address.setState("Maharashtra"); address.setCountry("India");
	 * address.setPostalCode("400001");
	 * 
	 * address.setShipping(true);
	 * 
	 * address.setUser(user);
	 * 
	 * 
	 * assertEquals("Failed to add the shipping address!", true,
	 * userDao.addAddress(address));
	 * 
	 * 
	 * 
	 * }
	 */
	
	/*
	 * @Test public void testAddAddress() { user =
	 * userDao.getByEmail("ss@gmail.com");
	 * 
	 * address = new Address(); address.setAddressLineOne("m-77, Krissh Nagar");
	 * address.setAddressLineTwo("Near Kaabil Store"); address.setCity("Gzb");
	 * address.setState("UP"); address.setCountry("India");
	 * address.setPostalCode("400001"); address.setBilling(true);
	 * 
	 * address.setUser(user);
	 * 
	 * assertEquals("failed to address added in cart",
	 * true,userDao.addAddress(address));
	 * 
	 * }
	 */
	
	
	
	
	@Test
	public void testGetAddress()
	{
		user = userDao.getByEmail("ss@gmail.com");
		
		
		assertEquals("failed to fetch list shipping address", 1,userDao.listshippingAddress(user).size());
		
		assertEquals("failed to fetch list billing address","UP",userDao.getBillingAddress(user).getCity());
		
	}
	
	
}
	
	
	
