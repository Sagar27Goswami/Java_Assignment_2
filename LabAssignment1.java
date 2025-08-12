package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LabAssignment1 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try (Connection con = DriverManager.getConnection(url, user, password);
	             Statement stmt = con.createStatement();
	             ResultSet rs = stmt.executeQuery("SELECT * FROM employees")) {

	            while (rs.next()) {
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                double salary = rs.getDouble("salary");
	                System.out.println(id + "  " + name + "  " + salary);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


