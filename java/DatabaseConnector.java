package com.heart.bean;

import java.sql.*;

public class DatabaseConnector {

	 public static Connection getConnection() {
	        Connection con = null;
	        String driver = "com.mysql.jdbc.Driver";
	        try {
	            Class.forName(driver).newInstance();

	        } catch (Exception e) {
	            System.out.println("Failed to load mySQL driver.");
	            return null;
	        }
	        try {
	            con = DriverManager
	                    .getConnection("jdbc:mysql://localhost:3306/heartdisease","root","password");

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
}