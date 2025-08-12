package com.util;

import java.sql.Connection;

import java.sql.DriverManager;

public class StudentConnection  {
	
	

	    Connection cn = null;

	    public Connection getConnection() throws Exception {
	        
	        Class.forName("com.mysql.jdbc.Driver");
	        cn = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/employeemvc", "root", "");
	        return cn;
	    }

	   
	    public static void main(String[] args) {
	        try {
	            DBConnection db = new DBConnection();
	            Connection con = db.getConnection();
	            System.out.println("Database connected successfully!");
	            con.close();
	            System.out.println("Connection closed.");
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
