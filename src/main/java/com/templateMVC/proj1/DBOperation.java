package com.templateMVC.proj1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.templateMVC.proj1.Domain.Products;
import com.templateMVC.proj1.Domain.User;

public class DBOperation {
    private static Connection connection;
	public DBOperation() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Login","root", "root");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User","root", "root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	

	public static Connection getConnection(){
		try {
			if(connection!=null && !connection.isClosed())
				return connection;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/User","root", "root");
			//connection = DriverManager.getConnection("jdbc:mysql://ec2-50-19-213-178.compute-1.amazonaws.com:3306/jobquest","birvajoshi", "birva123");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return connection;
	}
	
	public void insertProduct(User user, Products prod) throws SQLException{
		DBOperation dbOperation = new DBOperation();
		Connection dbConnection = dbOperation.getConnection();
		String product_name = prod.getProduct_name();
		String product_category = prod.getCategory();
		String product_details = prod.getDetails();
		String username = user.getUsername();
		
		if(dbConnection!=null){
			PreparedStatement prepStatement2 = dbConnection.prepareStatement("insert into ShoppingCart (username ,product_name, product_category, product_details) values (?,?,?,?)");
			prepStatement2.setString(1, username);
			prepStatement2.setString(2, product_name);
			prepStatement2.setString(2, product_category);
			prepStatement2.setString(2, product_details);
			
		
			ResultSet results = prepStatement2.executeQuery();
			
		}
		
		
	}
}