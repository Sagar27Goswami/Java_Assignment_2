package com.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Lab2 {

		    public static void main(String[] args) {
		        String url = "jdbc:mysql://localhost:3306/testdb?useSSL=false&serverTimezone=UTC";
		        String user = "root";
		        String password = "";

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");

		          
		            Connection con = DriverManager.getConnection(url, user, password);
		            Statement st = con.createStatement();


		            String insertQuery = "INSERT INTO employees (id, name, salary) VALUES (1, 'John Doe', 50000)";
		            int rowsInserted = st.executeUpdate(insertQuery);
	               System.out.println(rowsInserted + " row(s) inserted.");

		          
		            String updateQuery = "UPDATE employees SET salary = 55000 WHERE id = 1";
		            int rowsUpdated = st.executeUpdate(updateQuery);
		            System.out.println(rowsUpdated + " row(s) updated.");

		         
		            String selectQuery = "SELECT * FROM employees";
		            ResultSet rs = st.executeQuery(selectQuery);
		            System.out.println("\nEmployee Table:");
		            while (rs.next()) {
		                System.out.println(rs.getInt("id") + "" + rs.getString("name") + "" + rs.getDouble("salary"));
		            }
		            String deleteQuery = "DELETE FROM employees WHERE id = 1";
		            int rowsDeleted = st.executeUpdate(deleteQuery);
		            System.out.println(rowsDeleted + " row(s) deleted.");

		           
		            st.close();
		            con.close();
		        } 
		        catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
}
		    
		




