package com.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;

public class Lab7 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            // Get database metadata object
	            DatabaseMetaData metaData = con.getMetaData();

	            // Retrieve and print metadata information
	            System.out.println("Database Product Name: " + metaData.getDatabaseProductName());
	            System.out.println("Database Product Version: " + metaData.getDatabaseProductVersion());
	            System.out.println("Driver Name: " + metaData.getDriverName());
	            System.out.println("Driver Version: " + metaData.getDriverVersion());
	            System.out.println("URL: " + metaData.getURL());
	            System.out.println("User Name: " + metaData.getUserName());

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


