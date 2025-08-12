package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Lab81 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb";
	        String user = "root";
	        String password = "";

	        try (Connection con = DriverManager.getConnection(url, user, password);
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM employees LIMIT 1")) {

	            ResultSetMetaData meta = rs.getMetaData();
	            int count = meta.getColumnCount();

	            System.out.println("Columns count: " + count);

	            for (int i = 1; i <= count; i++) {
	                System.out.println(meta.getColumnName(i) + " - " + meta.getColumnTypeName(i));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


