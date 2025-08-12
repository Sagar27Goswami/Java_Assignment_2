package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lab62 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection con = DriverManager.getConnection(url, user, password);

	            // Create scrollable ResultSet
	            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employees");

	            // Move forward
	            System.out.println("Forward:");
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") + " | " + rs.getString("name"));
	            }

	            // Move backward
	            System.out.println("\nBackward:");
	            while (rs.previous()) {
	                System.out.println(rs.getInt("id") + " | " + rs.getString("name"));
	            }

	            // Go to specific positions
	            if (rs.first())
	                System.out.println("\nFirst row: " + rs.getInt("id") + " | " + rs.getString("name"));

	            if (rs.last())
	                System.out.println("Last row: " + rs.getInt("id") + " | " + rs.getString("name"));

	            if (rs.absolute(2))
	                System.out.println("Row 2: " + rs.getInt("id") + " | " + rs.getString("name"));

	            if (rs.relative(1))
	                System.out.println("Next row (relative +1): " + rs.getInt("id") + " | " + rs.getString("name"));

	            if (rs.relative(-2))
	                System.out.println("Previous row (relative -2): " + rs.getInt("id") + " | " + rs.getString("name"));

	            rs.close();
	            stmt.close();
	            con.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


