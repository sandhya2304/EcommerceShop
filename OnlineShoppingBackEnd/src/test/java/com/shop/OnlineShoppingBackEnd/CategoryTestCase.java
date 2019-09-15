package com.shop.OnlineShoppingBackEnd;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.shop.OnlineShoppingBackEnd.dao.CategoryDao;
import com.shop.OnlineShoppingBackEnd.dto.Category;

public class CategoryTestCase
{
	
	private static AnnotationConfigApplicationContext context;
	
	private static Category category;
	
	private static CategoryDao catDao;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("com.shop.OnlineShoppingBackEnd");
		context.refresh();
		
		catDao = (CategoryDao) context.getBean("categoryDao");
			
	}
	
	/*
	 * @Test public void testCategorySave() { category = new Category();
	 * category.setName("clothes"); category.setDescription("clothes ");
	 * category.setImageURL("clothes.jpg");
	 * 
	 * assertEquals("data saved in category",true,catDao.saveCategory(category)); }
	 */
	/*
	 * @Test public void testSingleCategory() { category = catDao.findById(1);
	 * assertEquals("fetch category","branding",category.getName());
	 * 
	 * }
	 */
	
	/*
	 * @Test public void testSingleCategoryUpdate() { category = catDao.findById(2);
	 * category.setName("cleansing");
	 * assertEquals("update category",true,catDao.updateCategory(category));
	 * 
	 * }
	 */
	
	
	/*
	 * @Test public void testdeleteCategory() { category = catDao.findById(2);
	 * assertEquals("update category",true,catDao.deleteCategory(category));
	 * 
	 * }
	 */
	
	/*
	 * @Test public void testActiveCategory() {
	 * assertEquals("active category",2,catDao.findAll().size());
	 * 
	 * }
	 */
	/*
	 * @Test public void testCRUDCategory() { category = new Category();
	 * category.setName("yes"); category.setDescription(" yes ");
	 * category.setImageURL("yes.jpg");
	 * 
	 * assertEquals("data saved in category",true,catDao.saveCategory(category));
	 * 
	 * 
	 * category = catDao.findById(2); category.setName("cleansing");
	 * assertEquals("update category",true,catDao.updateCategory(category));
	 * 
	 * category = catDao.findById(2);
	 * assertEquals("update category",true,catDao.deleteCategory(category));
	 * 
	 * assertEquals("active category",3,catDao.findAll().size());
	 * 
	 * }
	 */

}
