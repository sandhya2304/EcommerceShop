package com.shop.OnlineShoppingBackEnd.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.OnlineShoppingBackEnd.dao.ProductDao;
import com.shop.OnlineShoppingBackEnd.dto.Product;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao
{
	@Autowired
	private SessionFactory sessionFactory;
	

	@Override
	public List<Product> listAll()
	{
		
		String sql = "FROM Product";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		
		return query.getResultList();
	}

	@Override
	public Product findById(int id) 
	{
		return sessionFactory.getCurrentSession().get(Product.class,Integer.valueOf(id));
	}

	@Override
	public boolean saveProduct(Product product)
	{
		try
		{
			sessionFactory.getCurrentSession().persist(product);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteProduct(Product product)
	{
		product.setActive(false);
		
		try
		{
			sessionFactory.getCurrentSession().update(product);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateProduct(Product product) {
		try
		{
			sessionFactory.getCurrentSession().update(product);
			
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Product> listActiveProducts()
	{
		String sql = "FROM Product where active = :active";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("active",true);
		return query.getResultList();
	}

	@Override
	public List<Product> listActiveProductsByCategory(int categoryId)
	{
		String sql = "FROM Product where active = :active and categoryId = :categoryId";
		Query query = sessionFactory.getCurrentSession().createQuery(sql);
		query.setParameter("categoryId",categoryId);
		query.setParameter("active",true);
		return query.getResultList();
	}

	@Override
	public List<Product> getLatestActiveProduct(int count)
	{
		return sessionFactory
				 .getCurrentSession()
				    .createQuery("From Product where active = :active Order By id",Product.class)
				      .setParameter("active",true)
				        .setFirstResult(0)
				          .setMaxResults(count)
				           .getResultList();
				        
				
	}
	
	
	

}
