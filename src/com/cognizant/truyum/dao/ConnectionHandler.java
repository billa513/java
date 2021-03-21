package com.cognizant.truyum.dao;

import java.io.FileInputStream;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
public static Connection getConnectoin() throws IOException, ClassNotFoundException {
	
	 Connection con= null;
     try {
         FileInputStream file = new FileInputStream("src/connection.properties");
         Properties properties = new Properties();
         properties.load(file);
         Class.forName(properties.getProperty("driver"));
         con = DriverManager.getConnection(properties.getProperty("connection-url"), properties.getProperty("user"), properties.getProperty("password"));
       
     } catch (SQLException throwables) {
         throwables.printStackTrace();
     }

      return con;
	
}
}
