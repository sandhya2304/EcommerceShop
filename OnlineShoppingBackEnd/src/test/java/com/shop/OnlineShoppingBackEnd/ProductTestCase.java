package com.shop.OnlineShoppingBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dto.Product;

public class ProductTestCase
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static ProductDao productDao;
	
	private  Product product;
	
	@BeforeClass
	public static void  init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop.OnlineShoppingBackEnd");
		context.refresh();
		
		productDao = (ProductDao) context.getBean("productDao");
		
	}
	
	/*
	 * @Test public void testSaveProduct() { Product product = new Product();
	 * product.setName("OppoSelfie"); product.setBrand("Oppo");
	 * product.setDescription("This is new Oppo"); product.setUnitPrice(12000);
	 * product.setActive(true); product.setCategoryId(3); product.setSupplierId(3);
	 * 
	 * assertEquals("product saved",true,productDao.saveProduct(product)); }
	 */

	/*
	 * @Test public void testGetProduct() { Product product =
	 * productDao.findById(1);
	 * 
	 * assertEquals("product fetch","iPhone 5s", product.getName()); }
	 */
	
	/*
	 * @Test public void testUpdateProduct() { Product product =
	 * productDao.findById(1); product.setName("change");
	 * 
	 * assertEquals("product fetch",true, productDao.updateProduct(product)); }
	 */
	
	/*
	 * @Test public void testDeleteProduct() { Product product =
	 * productDao.findById(2); assertEquals("product fetch",true,
	 * productDao.deleteProduct(product)); }
	 */
	/*
	 * @Test public void testDeleteProduct() { assertEquals("product fetch all",6,
	 * productDao.listAll().size()); }
	 */
	

	/*
	 * @Test public void testDeleteProduct() { assertEquals("product fetch all",5,
	 * productDao.listActiveProducts().size()); }
	 */
	/*
	 * @Test public void testDeleteProduct() { assertEquals("product fetch all",3,
	 * productDao.listActiveProductsByCategory(3).size()); }
	 */
	

	@Test
	public void testDeleteProduct()
	{
		assertEquals("product fetch all",3, productDao.getLatestActiveProduct(3).size());    
	}

}
