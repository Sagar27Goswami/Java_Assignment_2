package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lab4 {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            
	            Connection con = DriverManager.getConnection(url, user, password);

	           
	            String insertSQL = "INSERT INTO employees (id, name, salary) VALUES (?, ?, ?)";
	            PreparedStatement pstmtInsert = con.prepareStatement(insertSQL);
	            pstmtInsert.setInt(1, 1);
	            pstmtInsert.setString(2, "John Doe");
	            pstmtInsert.setDouble(3, 50000);
	            int rowsInserted = pstmtInsert.executeUpdate();
	            System.out.println(rowsInserted + " row(s) inserted.");

	          
	            String updateSQL = "UPDATE employees SET salary = ? WHERE id = ?";
	            PreparedStatement pstmtUpdate = con.prepareStatement(updateSQL);
	            pstmtUpdate.setDouble(1, 55000);
	            pstmtUpdate.setInt(2, 1);
	            int rowsUpdated = pstmtUpdate.executeUpdate();
	            System.out.println(rowsUpdated + " row(s) updated.");

	           
	            String selectSQL = "SELECT * FROM employees";
	            PreparedStatement pstmtSelect = con.prepareStatement(selectSQL);
	            ResultSet rs = pstmtSelect.executeQuery();
	            System.out.println("\nEmployee Table:");
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getDouble("salary"));
	            }

	           
	            String deleteSQL = "DELETE FROM employees WHERE id = ?";
	            PreparedStatement pstmtDelete = con.prepareStatement(deleteSQL);
	            pstmtDelete.setInt(1, 1);
	            int rowsDeleted = pstmtDelete.executeUpdate();
	            System.out.println(rowsDeleted + " row(s) deleted.");

	          
	            con.close();
	        } 
	        catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


