package com.templateMVC.proj1;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.templateMVC.proj1.Domain.Products;


public class getMongoConnection {
	
	public ArrayList<Products> getConn() throws UnknownHostException{
	
	    ArrayList<Products> products = new ArrayList<Products>();
	   
		
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		DB db = mongo.getDB("shopzone");
		DBCollection coll = db.getCollection("testcatalogue");
		System.out.println("Connected!!");
	
		DBCursor cursor = coll.find();
		System.out.println("testing count: "+cursor.count());
	
		while(cursor.hasNext()){
			
			System.out.println("Testing while loop for mongodb");
			
			DBObject theObj = cursor.next();
			Products prod = new Products();
			
			String id = theObj.get("product_id").toString();
			String category = theObj.get("category").toString();
			String details = theObj.get("details").toString();
			String name = theObj.get("product_name").toString();
			
			prod.setProductid(id);
			System.out.println("ID :: " + prod.getProductid());
			
			prod.setCategory(category);
			System.out.println("Category :: " + prod.getCategory());
			
			prod.setDetails(details);
			System.out.println("Details :: " + prod.getDetails());
			
			prod.setProduct_name(name);
			System.out.println("Name :: " + prod.getProduct_name());
			
			products.add(prod);

			/*	BasicDBList productList = (BasicDBList) theObj.get("products");
			for(int i = 0; i < productList.size(); i++){

			BasicDBObject productObj = (BasicDBObject) productList.get(i);
			String product_id = productObj.getString("product_id").toString();
			String category = productObj.getString("category").toString();	


			prod.setProductid(product_id)
			prod.setCategory(category);			*/


		}	
		return products;
	}

	public Products getProduct(String prodname) throws UnknownHostException{
		
		Products product = new Products();
		
		MongoClient mongo = new MongoClient( "localhost" , 27017 );
		DB db = mongo.getDB("shopzone");
		BasicDBObject obj1 = new BasicDBObject();
		obj1.put("product_name", prodname);
		DBCollection coll = db.getCollection("testcatalogue");
		
		DBCursor cursor = coll.find(obj1);
		
		String id = obj1.get("product_id").toString();
		String category = obj1.get("category").toString();
		String details = obj1.get("details").toString();
		String name = obj1.get("product_name").toString();
		
		product.setProductid(id);
		product.setCategory(category);
		product.setDetails(details);
		product.setProduct_name(name);
		
		return product;
	}
}
