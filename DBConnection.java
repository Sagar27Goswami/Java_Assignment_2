package com.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    Connection cn=null;
    
    public Connection getConnection() throws Exception{
    	Class.forName("com.mysql.jdbc.Driver");
    	cn= DriverManager.getConnection("jdbc:mysql://localhost:3306/employeemvc","root","");
    	return cn;
    }
    
}
