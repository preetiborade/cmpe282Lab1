package com.templateMVC.proj1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.jdbc.Statement;



import com.mysql.jdbc.Statement;
import com.templateMVC.proj1.DBOperation;

public class signUpUser{

	public void signUp(String fname , String lname, String user, String password)
	{
	
		java.sql.Statement stmt = null;
	
		System.out.println("Username::"+user+"  Password::"+password);
		DBOperation dbOperation = new DBOperation();
		Connection dbConnection = dbOperation.getConnection();

		if(dbConnection!=null)
		{
			try
			{
				stmt = dbConnection.createStatement();
				
				
				PreparedStatement prepStatement2 = dbConnection.prepareStatement("insert into Users (user_name, password, fname, lname) values (? ,? ,? ,?);");
				prepStatement2.setString(1, user);
				prepStatement2.setString(2, password);
				prepStatement2.setString(3, fname);
				prepStatement2.setString(4, lname);
		
				prepStatement2.executeUpdate();
			}
		
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
	}
	
}
				
				
				