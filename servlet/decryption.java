package com.heart.servlet;

import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;
import java.util.Date;
import java.awt.Color;
import java.util.Calendar;
import java.net.*;

import java.security.Key; 
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.KeyGenerator; 
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import pantech.common.Common_DB;
import com.heart.bean.DatabaseConnector;

public class decryption extends HttpServlet {
  HttpSession session;
  Connection con;
  String date;
  String queryString="";
 
  static String filename;
  static String time, result1;
  static String filepath;
  static String currentNo,file,docname, docno;
  static String username="";
  static String telephone,id;
  static String outString="";
  static String outString1="";   
  static Hashtable inputData2;
  static String secretkey;
  public void init(ServletConfig sc )throws ServletException{super.init(sc);}

   public void doGet(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException {
      doPost(req,res);
   }

   public void doPost(HttpServletRequest req,HttpServletResponse res)
	   throws ServletException,IOException {
	   PrintWriter out=res.getWriter();
	   String outString2="";
	 session=req.getSession(true);
	 
	 username=(String)session.getAttribute("username");
	// filename=(String)session.getAttribute("filename");
	 secretkey=req.getParameter("pass");
     con = DatabaseConnector.getConnection();
     filepath = getServletContext().getRealPath("reports/");
	String resultpage=null;

	 try {
		    queryString = "select * from register where username='"+username+"';";
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery(queryString);
			  if(result.next())	{
				  	Key key1 = generateKey();
					BufferedReader br = new BufferedReader(new FileReader(new File(filepath+"/filename.txt")));
					String filenumber = br.readLine();
		outString1 ="D:/Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\encrypt\\"+filenumber+".pdf";
		outString2 ="D:/Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\decrypt/"+filenumber+".pdf";
		resultpage="/HeartDisease/decrypt/"+filenumber+".pdf";
		
		AESEncrypter aes = new AESEncrypter((SecretKey)key1);
	
		//decrypt
		aes.decrypt(new FileInputStream(outString1),new FileOutputStream(outString2));
		System.out.println("decryption called");
		   }else {
			   outString=outString1;
		   }
		out.println("<html><head><script type='text/javascript'>function load(){location.href='"+resultpage+"';}</script></head><body onload='load()'>");
		out.println("</body></html>");
	  }catch(Exception e) {
	   	   System.out.println("Sql Exception : "+e.toString());
	   }
	 
    }

    private static Key generateKey() {
		try{
        String keyValue=secretkey;
        Key key = new SecretKeySpec(keyValue.getBytes(), "AES");
		return key;		
		}
		catch(Exception e){
		return null;
		}
    }


}