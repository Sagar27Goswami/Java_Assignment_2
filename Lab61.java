package com.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Lab61 {
	


		
		    public static void main(String[] args) {
		        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		        String user = "root";
		        String password = "";

		        try {
		           
		            Class.forName("com.mysql.cj.jdbc.Driver");

		           
		            Connection con = DriverManager.getConnection(url, user, password);

		       
		            String selectSQL = "SELECT id, name, salary FROM employees";
		            PreparedStatement pstmt = con.prepareStatement(selectSQL);

		            
		            ResultSet rs = pstmt.executeQuery();

		           
		            System.out.println("Employee Records:");
		            while (rs.next()) {
		                int id = rs.getInt("id");                
		                String name = rs.getString("name");     
		                double salary = rs.getDouble("salary"); 
		                
		                System.out.println(id + " | " + name + " | " + salary);
		            }

		           
		            rs.close();
		            pstmt.close();
		            con.close();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		




}

