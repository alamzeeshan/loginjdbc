package com.rameez.movies.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImpl 
{

	
	
	public String authorise(String username,String password) {
		System.out.println("In jdbcTest ################################");

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String oracleUsername = "monitoring";
		String oraclePassword = "monitoring";

		String sql = "select USERNAME, PASSWORD from CREDENTIALS where USERNAME = ?";// and password = ?";
		Connection connection = null;
		String result = "";
		try {
			// STEP 2: Register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// STEP 3: Open a connection
			connection = DriverManager.getConnection(url, oracleUsername, oraclePassword);

			// STEP 4: Execute a query
			System.out.println("Creating statement...");
			// Statement statement = connection.createStatement();

			PreparedStatement statement=connection.prepareStatement(sql);
			statement.setString(1, username);//1 specifies the first parameter in the query  
			//statement.setString(2, password);
			
			ResultSet rs = statement.executeQuery();

			// STEP 5: Extract data from result set
			
			/*if(!rs.isBeforeFirst()) {
				
			}*/
			
			if(rs.isBeforeFirst()) {
				while (rs.next()) {
					String user  = rs.getString("USERNAME");
					String pwd  = rs.getString("PASSWORD");
					System.out.println(user);
					System.out.println(pwd);
					
					if(pwd.equals(password)) {
						result =  "true";
					} else {
						result =  "Error: Invalid Password";
					}
				}
			} else {
				result =  "Error: Invalid Username";
			}

			

			// STEP 6: Clean-up environment
			rs.close();
			statement.close();
			connection.close();
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException se) {
				se.printStackTrace();
			} // end finally try
		} // end try

		return result;
	}
}
