package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Lab3 {

	    public static void main(String[] args) {
	        // Database connection details
	        String url = "jdbc:mysql://localhost:3306/testdb"; 
	        String username = "root"; 
	        String password = "your_password"; 

	        try {
	            
	            Class.forName("com.mysql.cj.jdbc.Driver");

	           
	            Connection conn = DriverManager.getConnection(url, username, password);

	            
	            System.out.println("Connected to the database successfully!");

	            
	            conn.close();
	            System.out.println("Connection closed.");
	        } 
	        catch (ClassNotFoundException e) {
	            System.out.println("MySQL JDBC Driver not found!");
	            e.printStackTrace();
	        } 
	        catch (SQLException e) {
	            System.out.println("Database connection failed!");
	            e.printStackTrace();
	        }
	    }
	}


