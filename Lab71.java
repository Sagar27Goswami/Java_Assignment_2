package com.util;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;



public class Lab71 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            DatabaseMetaData metaData = con.getMetaData();

	            // Database name and version
	            System.out.println("Database Name: " + metaData.getDatabaseProductName());
	            System.out.println("Database Version: " + metaData.getDatabaseProductVersion());

	            // List tables
	            System.out.println("\nList of Tables:");
	            ResultSet tables = metaData.getTables(null, null, "%", new String[] {"TABLE"});
	            while (tables.next()) {
	                System.out.println(tables.getString("TABLE_NAME"));
	            }
	            tables.close();

	            // Supported SQL keywords
	            System.out.println("\nSupported SQL Keywords:");
	            System.out.println(metaData.getSQLKeywords());

	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


