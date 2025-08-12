package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Lab10 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try (Connection con = DriverManager.getConnection(url, user, password)) {

	            // Insert
	            String insertSQL = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
	            PreparedStatement insertStmt = con.prepareStatement(insertSQL);
	            insertStmt.setInt(1, 1);
	            insertStmt.setString(2, "Alice");
	            insertStmt.setDouble(3, 60000);
	            insertStmt.executeUpdate();

	            // Update
	            String updateSQL = "UPDATE employees SET salary = ? WHERE id = ?";
	            PreparedStatement updateStmt = con.prepareStatement(updateSQL);
	            updateStmt.setDouble(1, 65000);
	            updateStmt.setInt(2, 1);
	            updateStmt.executeUpdate();

	            // Select
	            String selectSQL = "SELECT * FROM employees";
	            PreparedStatement selectStmt = con.prepareStatement(selectSQL);
	            ResultSet rs = selectStmt.executeQuery();
	            System.out.println("Employees:");
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getDouble("salary"));
	            }
	            rs.close();

	            // Delete
	            String deleteSQL = "DELETE FROM employees WHERE id = ?";
	            PreparedStatement deleteStmt = con.prepareStatement(deleteSQL);
	            deleteStmt.setInt(1, 1);
	            deleteStmt.executeUpdate();

	            // Close statements
	            insertStmt.close();
	            updateStmt.close();
	            selectStmt.close();
	            deleteStmt.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


