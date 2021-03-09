package com.heart.servlet;

import com.heart.bean.Database;
import com.heart.bean.HeartBean;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class HeartAuthentication extends HttpServlet
{
  HttpSession session;
  PrintWriter out;
  Database db=null;
  ResultSet rs=null;
  String age;
  String sex;
  String ChestPain;
  String BloodPressure;
  String Cholestrol;
  String BloodSugar;
  String Electrocardiographic;
  String Thalach;
  String Exang;
  String OldPeak;
  String Slope;
  String CA;
  String Thal;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  {
      doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
  {
      HeartBean heartbean = null;
      try
      {
          age=request.getParameter("age");
          sex=request.getParameter("sex");
          ChestPain=request.getParameter("ChestPain");
          BloodPressure=request.getParameter("BloodPressure");
          Cholestrol=request.getParameter("Cholestrol");
          BloodSugar=request.getParameter("BloodSugar");
          Electrocardiographic=request.getParameter("Electrocardiographic");
          Thalach=request.getParameter("Thalach");
          Exang=request.getParameter("Exang");
          OldPeak=request.getParameter("OldPeak");
          Slope=request.getParameter("Slope");
          CA=request.getParameter("CA");
          Thal=request.getParameter("Thal");

          heartbean = new HeartBean();
          heartbean.setAge(age);
	      heartbean.setSex(sex);
	      heartbean.setChestPain(ChestPain);
	      heartbean.setBloodPressure(BloodPressure);
	      heartbean.setCholestrol(Cholestrol);
	      heartbean.setBloodSugar(BloodSugar);
	      heartbean.setElectrocardiographic(Electrocardiographic);
	      heartbean.setThalach(Thalach);
	      heartbean.setExang(Exang);
	      heartbean.setOldPeak(OldPeak);
	      heartbean.setSlope(Slope);
	      heartbean.setCA(CA);
	      heartbean.setThal(Thal);
          request.setAttribute("heartbean", heartbean);
         if(heartbean.isValidate())
           {
               try
               {
                  db = new Database();
		          final String query ="insert into register values('"+age+"','"+sex+"','"+ChestPain+"','"+BloodPressure+"','"+Cholestrol+"','"+BloodSugar+"','"+Electrocardiographic+"','"+Thalach+"','"+Exang+"','"+OldPeak+"','"+Slope+"','"+CA+"','"+Thal+"')";
		          int result = db.executeUpdate(query);
		          //getServletConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
               }
               catch( Exception e)
               {
                  heartbean.setErrors("error",e.getMessage());
                  //getServletConfig().getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
               }
           }
           else
           {
              //getServletConfig().getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
           }

      }
      catch (Exception ex)
      {
	     ex.printStackTrace();
      }
  }
}