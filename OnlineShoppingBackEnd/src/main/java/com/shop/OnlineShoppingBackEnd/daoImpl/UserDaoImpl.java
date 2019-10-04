package com.shop.OnlineShoppingBackEnd.daoImpl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shop.OnlineShoppingBackEnd.dao.UserDao;
import com.shop.OnlineShoppingBackEnd.dto.Address;
import com.shop.OnlineShoppingBackEnd.dto.Cart;
import com.shop.OnlineShoppingBackEnd.dto.User;


@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addUser(User user) {
        try
        {
        	sessionFactory.getCurrentSession().persist(user);
        	return true;
        	
        }catch(Exception e)
        {
        	e.getMessage();
        }
		
		return false;
	}

	@Override
	public boolean addAddress(Address address)
	{
		try
		{
        	sessionFactory.getCurrentSession().persist(address);
        	return true;
        	
        }catch(Exception e)
        {
        	e.getMessage();
        }
		
		return false;
	}

	
	@Override
	public User getByEmail(String email)
	{
		String query = "FROM User where email =:email";
		try
		{
			return sessionFactory.getCurrentSession()
					  .createQuery(query,User.class)
					   .setParameter("email",email)
					     .getSingleResult();
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public Address getBillingAddress(User user)
	{
		String query = "FROM Address where user =:user and billing =:billing";
		try
		{
			return sessionFactory.getCurrentSession()
					  .createQuery(query,Address.class)
					   .setParameter("user",user)
					   .setParameter("billing", true)
					     .getSingleResult();
			
		}catch(Exception e)
		{
			e.getMessage();
		}
		
		return null;
	}

	@Override
	public List<Address> listshippingAddress(User user) 
		{
			String query = "FROM Address where user =:user and shipping =:shipping";
			try
			{
				return sessionFactory.getCurrentSession()
						  .createQuery(query,Address.class)
						   .setParameter("user",user)
						   .setParameter("shipping", true)
						     .getResultList();
				
			}catch(Exception e)
			{
				e.getMessage();
			}
			
			return null;
		}
	

}
