package com.shop.OnlineShoppingBackEnd.daoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.OnlineShoppingBackEnd.dao.CategoryDao;
import com.shop.OnlineShoppingBackEnd.dto.Category;


@Transactional
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao
{
	
	@Autowired
	private SessionFactory sessionFactory;
	

	
	
	@Override
	public List<Category> findAll() 
	{	
		String activeCatgeory = "FROM Category WHERE active = :active";
		Query quert = sessionFactory.getCurrentSession().createQuery(activeCatgeory);
		quert.setParameter("active",true);
		
		
		return quert.getResultList();
	}

	@Override
	public Category findById(int id)
	{

		return sessionFactory.getCurrentSession().get(Category.class, Integer.valueOf(id));

	}

	@Override
	
	public boolean saveCategory(Category category)
	{
		try
		{
			sessionFactory.getCurrentSession().persist(category);
	
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}

	@Override
	public boolean deleteCategory(Category category) {
		
		category.setActive(false);
		
		try
		{
			sessionFactory.getCurrentSession().update(category);
	
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateCategory(Category category) {
		try
		{
			sessionFactory.getCurrentSession().update(category);
	
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	
	

}
