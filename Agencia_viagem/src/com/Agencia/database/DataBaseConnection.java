package com.Agencia.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
  
	private static final String url = "jdbc:mysql://localhost:3306/agencia_recode";
	
	private static final String user = "root";
	
	private static final String password = "melissa";
	
	
	public static Connection createConnection() {
		
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println();
	} catch(ClassNotFoundException e ) {
		
		System.out.println( e.getMessage());	
	}
		
     try {
    	 Connection connection = DriverManager.getConnection(url,user, password);
    	 System.out.println("");
    	 return connection;
    	 
     } catch(SQLException e){
    	 System.out.println(  e.getMessage());
    	 return null;
     }
		
	}
}
