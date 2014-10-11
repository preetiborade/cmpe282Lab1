package com.templateMVC.proj1.Domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

public class Products implements Serializable{

	public String product_id;
	public String product_name;
	public String category;
	public String details;
	
	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getProductid() {
		return product_id;
	}
	
	public void setProductid(String product_id) {
		 this.product_id = product_id;
	}
		
	public String getCategory() {
		return category;
	}
		
	public void setCategory(String category) {
		this.category = category;
	}
}
