package com.util;

public class LabAssignment2 {
	
	    public static void main(String[] args) {
	        try {
	            // 1. Connect to database
	            Connection con = DriverManager.getConnection(
	                "jdbc:mysql://localhost:3306/testdb", "root", "");

	            // 2. Insert a new record
	            String insert = "INSERT INTO employees (id, name, salary) VALUES (1, 'John', 50000)";
	            Statement stmt = con.createStatement();
	            stmt.executeUpdate(insert);

	            // 3. Update the record
	            String update = "UPDATE employees SET salary = 55000 WHERE id = 1";
	            stmt.executeUpdate(update);

	            // 4. Select and display records
	            String select = "SELECT * FROM employees";
	            ResultSet rs = stmt.executeQuery(select);
	            while (rs.next()) {
	                System.out.println(rs.getInt("id") + " " +
	                                   rs.getString("name") + " " +
	                                   rs.getDouble("salary"));
	            }

	            // 5. Delete the record
	            String delete = "DELETE FROM employees WHERE id = 1";
	            stmt.executeUpdate(delete);

	            // 6. Close resources
	            rs.close();
	            stmt.close();
	            con.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


