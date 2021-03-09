package com.heart.servlet;

import com.heart.bean.Database;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection.*;
import java.sql.ResultSet.*;

public class RegisterAuthentication extends HttpServlet
{
  HttpSession session;
  Database db=null;
  ResultSet rs=null;
  String username;
  String password;
  String hintquestion;
  String hintanswer;
  String firstname;
  String lastname;
  String address1;
  String address2;
  String telephone;
  String city;
  String state;
  String country;
  String zipcode;
  public void doGet(HttpServletRequest request, HttpServletResponse response)
  {
      doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
  {
      try
      {
          username=request.getParameter("username");
          password=request.getParameter("password");
          hintquestion=request.getParameter("hintquestion");
          hintanswer=request.getParameter("hintanswer");
          firstname=request.getParameter("firstname");
          lastname=request.getParameter("lastname");
          address1=request.getParameter("address1");
          address2=request.getParameter("address2");
          telephone=request.getParameter("telephone");
          city=request.getParameter("city");
          state=request.getParameter("state");
          country=request.getParameter("country");
          zipcode=request.getParameter("zipcode");
               try
               {
                    db = new Database();
                    final String query1 = "select * from register where username='"+username+"'";
                   	rs = db.executeQuery(query1);
	              	if(rs.next()) {
					  getServletConfig().getServletContext().getRequestDispatcher("/pages/register.jsp").forward(request, response);
                    } else {
     	              final String query ="insert into register(username,password,hintquestion,hintanswer,firstname,lastname,address1,address2,telephone,city,state,country,zipcode)values('"+username+"','"+password+"','"+hintquestion+"','"+hintanswer+"','"+firstname+"','"+lastname+"','"+address1+"','"+address2+"','"+telephone+"','"+city+"','"+state+"','"+country+"','"+zipcode+"')";
		              int result = db.executeUpdate(query);
		              response.setContentType("text/xml");
                      response.setHeader("Cache-Control", "no-cache");
                      String outString = "success";
                      response.getWriter().write(outString);
                    }
               }
               catch(Exception e)
               {
                   //getServletConfig().getServletContext().getRequestDispatcher("/pages/home.jsp").forward(request, response);
               }
      }
      catch (Exception ex)
      {
	     ex.printStackTrace();
      }
  }
}