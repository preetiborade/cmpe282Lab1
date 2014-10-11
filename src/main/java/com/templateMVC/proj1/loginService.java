package com.templateMVC.proj1;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import com.mysql.jdbc.Statement;

import com.templateMVC.proj1.DBOperation;

public class loginService {
	
	ResultSet results = null;
	
	public boolean isValidUser(String user, String password )
	{
		System.out.println("Username::"+user+"  Password::"+password);
		DBOperation dbOperation = new DBOperation();
		Connection dbConnection = dbOperation.getConnection();
	
		if(dbConnection!=null)
		{
			try
			{
				PreparedStatement prepStatement2 = dbConnection.prepareStatement("Select * from Users where user_name=? and password=?");
				prepStatement2.setString(1, user);
				prepStatement2.setString(2, password);				
			
				ResultSet results = prepStatement2.executeQuery();
				
				if(!results.next())
				{
					return false;
				}
				else 
					return true;
			}
			
			catch (SQLException e) 
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return true;
	}
}		
				
				
				
				
				
				
				
				