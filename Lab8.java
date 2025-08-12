package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Lab8 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            Statement stmt = con.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

	            ResultSetMetaData meta = rs.getMetaData();
	            int columnCount = meta.getColumnCount();

	            System.out.println("Total Columns: " + columnCount);

	            for (int i = 1; i <= columnCount; i++) {
	                System.out.println("Column " + i + ": " + meta.getColumnName(i) + " | Type: " + meta.getColumnTypeName(i));
	            }

	            rs.close();
	            stmt.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


