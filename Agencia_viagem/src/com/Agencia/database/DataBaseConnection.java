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
		System.out.println("driver encontrado");
	} catch(ClassNotFoundException e ) {
		
		System.out.println("driver não encontrado : Menssagen: " + e.getMessage());	
	}
		
     try {
    	 Connection connection = DriverManager.getConnection(url,user, password);
    	 System.out.println("Conectado com sucesso");
    	 return connection;
    	 
     } catch(SQLException e){
    	 System.out.println("Não foi possivel se conectar com o banco: Menssagen: " + e.getMessage());
    	 return null;
     }
		
	}
}
