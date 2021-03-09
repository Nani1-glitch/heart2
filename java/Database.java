package com.heart.bean;

import java.io.*;
import java.util.*;
import java.sql.*;

public class Database implements Serializable
{
   	private static String  jdbcDriver = "";
  	private static String  dbURL = "";
	private static String  username = "";
	private static String  password = "";

	private Connection con;


  	public Database() throws SQLException, ClassNotFoundException
  	{
         ResourceBundle bundle = ResourceBundle.getBundle("/MessageResources");
		 jdbcDriver = bundle.getString("jdbc.driver");
		 dbURL =  bundle.getString("jdbc.url");
		 username = bundle.getString("jdbc.user");
		 password = bundle.getString("jdbc.password");
         Class.forName(jdbcDriver); //set Java database connectivity driver
         con = DriverManager.getConnection(dbURL, username, password);
	}

	public ResultSet executeQuery(String query)throws SQLException
	{
	    PreparedStatement st  = con.prepareStatement(query);
        return st.executeQuery();
    }

	public int executeUpdate(String statement)throws SQLException
	{
		PreparedStatement st  = con.prepareStatement(statement);
        return st.executeUpdate();
	}

	public void close()
	{
		try
	    {
			con.close();
		}
	    catch (SQLException sqlException)
	    {
			sqlException.printStackTrace();
	    	con = null;
	    }
	}
	protected void finalize()
	{
		close();
	}
}