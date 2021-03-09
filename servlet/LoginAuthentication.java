package com.heart.servlet;

import com.heart.bean.Database;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.Connection.*;
import java.sql.ResultSet.*;

public class LoginAuthentication extends HttpServlet {

    Database db=null;
    ResultSet rs=null;
    String username;
    String password;
    HttpSession session;
    PrintWriter out;
    String outString;

    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException, ServletException {
        session=request.getSession(true);
        try {
            username=request.getParameter("username");
            password=request.getParameter("password");
			
                try {
                    db = new Database();
                    final String query = "select * from register where username='"+username+"' and password='"+password+"'";
                    rs = db.executeQuery(query);
		            response.setContentType("text/xml");
                    response.setHeader("Cache-Control", "no-cache");
                    if(rs.next()) {
                        session.setAttribute("username",username);
                        outString = "success";
                        response.getWriter().write(outString);
                    }else {
                         outString = "failure";
                         response.getWriter().write(outString);
                    }
                } catch(Exception e) {
                      System.out.println("Exception : "+e);
                }
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}