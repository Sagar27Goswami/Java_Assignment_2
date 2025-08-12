package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lab6 {
	
	    public static void main(String[] args) {
	        // Database connection details
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try {
	            // 1. Load MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 2. Establish connection to database
	            Connection con = DriverManager.getConnection(url, user, password);

	            // 3. Prepare SQL SELECT query
	            String sql = "SELECT id, name, salary FROM employees";
	            PreparedStatement pstmt = con.prepareStatement(sql);

	            // 4. Execute query and get ResultSet
	            ResultSet rs = pstmt.executeQuery();

	            // 5. Process ResultSet and display records
	            System.out.println("ID | Name | Salary");
	            System.out.println("-------------------");
	            while (rs.next()) {
	                int id = rs.getInt("id");             // Retrieve 'id' column
	                String name = rs.getString("name");   // Retrieve 'name' column
	                double salary = rs.getDouble("salary"); // Retrieve 'salary' column

	                System.out.println(id + " | " + name + " | " + salary);
	            }

	            // 6. Close resources
	            rs.close();
	            pstmt.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}




