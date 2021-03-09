package com.heart.servlet;

import com.heart.bean.Database;
import com.heart.bean.DatabaseConnector;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AjaxResponseServlet extends HttpServlet
{
 HttpSession session;
 Database db=null;
 ResultSet rs=null;
 int count =0;
 Hashtable inputData = new Hashtable();
 ArrayList data = new ArrayList();

  public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
  {
    session=req.getSession(true);
    String aa =(String)session.getAttribute("x");
    String key = req.getParameter("key");

    if (key != null)
    {
        if(key.equals("0")){                           //for at the first time question load
          count = Integer.parseInt(key);
          inputData.clear();
          session.setAttribute("inputData",inputData);
        } else {
           String temp =(String)session.getAttribute("count");   //not for first all are next question
           count = Integer.parseInt(temp);
           inputData.put(new Integer(count),key);
           session.setAttribute("data",inputData);
        }
         ++count;
         res.setContentType("text/xml");                          //for return ajax response object
         res.setHeader("Cache-Control", "no-cache");
         String outString = createJSONwithJSONsimple(count);
         res.getWriter().write(outString);
    }
    else
    {
      res.setContentType("text/xml");
      res.setHeader("Cache-Control", "no-cache");
      res.getWriter().write("?");
    }
  }

 public String createJSONwithJSONsimple(int x)
  {
    JSONObject jso = new JSONObject();
    JSONObject jso2 = new JSONObject();
    String question;
	String choice1;
	String choice2;
	String query ="",query2 ="",query3="";
	String choice3;
	String choice4;
	String details ="";
	int type;
	Connection con = DatabaseConnector.getConnection();
	 try {
		    int g= 3;
            query = "select * from question where qno='"+x+"';";
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery(query);
            while (result.next()){
				question = result.getString("question");//to get question from db
				choice1 = result.getString("choice1");
				choice2 = result.getString("choice2");
                choice3=result.getString("choice3");
                choice4 = result.getString("choice4");
	      		type = result.getInt("type");
	      		details=result.getString("details");  //to get details from db
				jso2.put("question",question);    //to set question in json
				jso2.put("choice1",choice1);
				jso2.put("choice2",choice2);
				jso2.put("choice3",choice3);
				jso2.put("choice4",choice4);
				jso2.put("type",type);
				jso2.put("details",details);      //to set details in json
				jso.put("conversion",jso2);
			}
       		 String temp = String.valueOf(count);
             session.setAttribute("count",temp);
        } catch (Exception e)
        {
            System.out.println("Exception :"+query+" "+e.getMessage());
        } finally
        {
            if (con != null)
            {
                try
                {
                    con.close();
                } catch (SQLException e) {
                }
            }
        }
    return(jso.toString());
  }
}