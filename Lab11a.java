package com.util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Lab11a {
	
	    public static void main(String[] args) {
	        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
	        String user = "root";
	        String password = "";

	        try (Connection con = DriverManager.getConnection(url, user, password)) {
	            
	            CallableStatement cs = con.prepareCall("{CALL GetFullName(?, ?)}");

	           
	            int employeeId = 1;
	            cs.setInt(1, employeeId); 

	         
	            cs.registerOutParameter(2, Types.VARCHAR);

	            
	            cs.execute();

	           
	            String fullName = cs.getString(2);
	            System.out.println("Employee Full Name: " + fullName);

	            cs.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}


