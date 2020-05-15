package com.shop.OnlineShopping.model;

import java.io.Serializable;

import com.shop.OnlineShoppingBackEnd.dto.Cart;

public class UserModel implements Serializable 
{
	
	private int id;
	private String fullname;
	private String email;
	private String role;
	private Cart cart;
	
	
	
	
	@Override
	public String toString() {
		return "UserModel [id=" + id + ", fullname=" + fullname + ", email=" + email + ", role=" + role + ", cart="
				+ cart + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	} 
	
	
	
	
	

}