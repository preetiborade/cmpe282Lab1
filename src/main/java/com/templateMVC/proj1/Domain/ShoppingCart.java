package com.templateMVC.proj1.Domain;

import java.util.Date;
import java.util.List;

public class ShoppingCart {

	public List<Products> products;
	public int orderNumber;
	public int userId;
	public Date timestamp;
	
	
	public List<Products> getProducts() {
		return products;
	}
	
	
	public void setProducts(List<Products> products) {
		this.products = products;
	}
	
	
	public int getOrderNumber() {
		return orderNumber;
	}
	
	
	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	
	public int getUserId() {
		return userId;
	}
	
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
