package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lab9 {

	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try (Connection con = DriverManager.getConnection(url, user, password)) {

	           PreparedStatement insert = con.prepareStatement("INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)");
	            insert.setInt(1, 1);
	            insert.setString(2, "John");
	            insert.setDouble(3, 50000);
	            insert.executeUpdate();

	           
	            PreparedStatement update = con.prepareStatement(
	                "UPDATE employees SET salary = ? WHERE id = ?");
	            update.setDouble(1, 55000);
	            update.setInt(2, 1);
	            update.executeUpdate();

	            PreparedStatement select = con.prepareStatement(
	                "SELECT * FROM employees WHERE salary > ?");
	            select.setDouble(1, 40000);
	            ResultSet rs = select.executeQuery();
	            while (rs.next()) {
	                System.out.println(
	                    rs.getInt("id") + " " + rs.getString("name") + " " + rs.getDouble("salary"));
	            }
	            rs.close();

	         
	            PreparedStatement delete = con.prepareStatement(
	                "DELETE FROM employees WHERE id = ?");
	            delete.setInt(1, 1);
	            delete.executeUpdate();

	            insert.close();
	            update.close();
	            select.close();
	            delete.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


