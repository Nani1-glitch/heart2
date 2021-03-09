package com.heart.servlet;

import com.heart.naivebayes.Detection;
import com.heart.naivebayes.Prediction;
import com.heart.naivebayes.Calculation;
import org.json.simple.JSONObject;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.awt.*;
import java.io.*;

import org.jfree.chart.*;
import org.jfree.chart.entity.*;
import org.jfree.data.general.*;

public class HeartActionServlet extends HttpServlet
{
  HttpSession session;
  String inputData;

  String Sex="";
  String ChestPain="";
  String BloodSugar="";
  String Restang="";
  String Exang="";
  String Slope="";
  String CA="";
  String Thal="";
  String result="";

  double Age;
  double BloodPressure;
  double Cholesterol;
  double Thalach;
  double Oldpeak;

  Hashtable inputData2;
  ArrayList data = new ArrayList();


  double pdfAgey,pdfAgen,pdfBPy,pdfBPn,pdfCOLy,pdfCOLn,pdfTHLy,pdfTHLn,pdfOPy,pdfOPn;
  double pdfSexy,pdfCPn,pdfSexn,pdfCPy,pdfBSy,pdfBSn,pdfRSy,pdfRSn,pdfExy,pdfExn,pdfSLy,pdfSLn,pdfCAy,pdfCAn;
  double pdfTALy,pdfTALn;
  double pdfDy,pdfDn;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
  {
      doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
  {
   try
   {
     session=request.getSession(true);
     inputData2 = (Hashtable)session.getAttribute("inputData");
     data.clear();
     for(int i=1;i<=inputData2.size();i++)
     {
        String temp=(String)inputData2.get(new Integer(i));
        data.add(temp);
     }
     Detection d2 = new Detection();
     Prediction p2 = new Prediction();
     Calculation c2 = new Calculation();
     d2.read();

     Sex=(String)data.get(1);
     ChestPain=(String)data.get(2);
     BloodSugar=(String)data.get(5);
     Restang=(String)data.get(6);
     Exang=(String)data.get(8);
     Slope=(String)data.get(10);
     CA=(String)data.get(11);
     Thal=(String)data.get(12);

     String Age1=(String)data.get(0);
     Age = Double.valueOf(Age1);

     String BloodPressure1=(String)data.get(3);
     BloodPressure = Double.valueOf(BloodPressure1);

     String Cholesterol1=(String)data.get(4);
     Cholesterol = Double.valueOf(Cholesterol1);

     String Thalach1=(String)data.get(7);
     Thalach = Double.valueOf(Thalach1);

     String Oldpeak1=(String)data.get(9);
     Oldpeak = Double.valueOf(Oldpeak1);

     pdfAgey = p2.findNumericalPDF(Age,c2.setMeanAgeD1(),c2.setStdAgeD1());
     pdfAgen = p2.findNumericalPDF(Age,c2.setMeanAgeD0(),c2.setStdAgeD0());

     pdfBPy = p2.findNumericalPDF(BloodPressure,c2.setMeanBloodPressureD1(),c2.setStdBloodPressureD1());
     pdfBPn = p2.findNumericalPDF(BloodPressure,c2.setMeanBloodPressureD0(),c2.setStdBloodPressureD0());

     pdfCOLy = p2.findNumericalPDF(Cholesterol,c2.setMeanCholesterolD1(),c2.setStdCholesterolD1());
     pdfCOLn = p2.findNumericalPDF(Cholesterol,c2.setMeanCholesterolD0(),c2.setStdCholesterolD0());

     pdfTHLy = p2.findNumericalPDF(Thalach,c2.setMeanThalachD1(),c2.setStdThalachD1());
     pdfTHLn = p2.findNumericalPDF(Thalach,c2.setMeanThalachD0(),c2.setStdThalachD0());

     pdfOPy = p2.findNumericalPDF(Oldpeak,c2.setMeanOldpeakD1(),c2.setStdOldpeakD1());
     pdfOPn = p2.findNumericalPDF(Oldpeak,c2.setMeanOldpeakD0(),c2.setStdOldpeakD0());

     if(Sex.equals("Male"))
     {
        pdfSexy = c2.setPdfMale1();
        pdfSexn = c2.setPdfMale0();
     } else {
        pdfSexy = c2.setPdfFemale1();
        pdfSexn = c2.setPdfFemale0();
     }
     if(ChestPain.equals("Type1_angina"))
     {
       pdfCPy = c2.setPdfCPType11();
       pdfCPn = c2.setPdfCPType10();
     } else if(ChestPain.equals("Type_angina")) {
       pdfCPy = c2.setPdfCPType1();
       pdfCPn = c2.setPdfCPType0();
     } else if(ChestPain.equals("Non_angina")) {
       pdfCPy = c2.setPdfCPNa1();
       pdfCPn = c2.setPdfCPNa0();
     } else if(ChestPain.equals("Asymptomatic")) {
       pdfCPy = c2.setPdfCPAy1();
       pdfCPn = c2.setPdfCPAy0();
     }
     if(BloodSugar.equals(">120"))
     {
       pdfBSy = c2.setPdfBSGt1();
       pdfBSn = c2.setPdfBSGt0();
     } else if(BloodSugar.equals("<120")) {
       pdfBSy = c2.setPdfBSLt1();
       pdfBSn = c2.setPdfBSLt0();
     }
     if(Restang.equals("Normal"))
     {
       pdfRSy = c2.setPdfResNL1();
       pdfRSn = c2.setPdfResNL0();
     } else if(Restang.equals("Abnormal")) {
       pdfRSy = c2.setPdfResABN1();
       pdfRSn = c2.setPdfResABN0();
     } else if(Restang.equals("Ventricular_hypertrophy")) {
       pdfRSy = c2.setPdfResHy1();
       pdfRSn = c2.setPdfResHy0();
     }
     if(Exang.equals("yes"))
     {
       pdfExy = c2.setPdfExY1();
       pdfExn = c2.setPdfExY0();
     } else if(Exang.equals("yes")) {
       pdfExy = c2.setPdfExN1();
       pdfExn = c2.setPdfExN0();
     }
     if(Slope.equals("unsloping"))
     {
       pdfSLy = c2.setPdfSlopeUs1();
       pdfSLn = c2.setPdfSlopeUs0();
     } else if(Slope.equals("flat")) {
       pdfSLy = c2.setPdfSlopeFt1();
       pdfSLn = c2.setPdfSlopeFt0();
     } else if(Slope.equals("downsloping")) {
       pdfSLy = c2.setPdfSlopeDs1();
       pdfSLn = c2.setPdfSlopeDs0();
     }
     if(CA.equals("0.0"))
     {
       pdfCAy = c2.setPdfCA0Bv1();
       pdfCAn = c2.setPdfCA0Bv0();
     } else if(CA.equals("1.0")) {
       pdfCAy = c2.setPdfCA1Bvl();
       pdfCAn = c2.setPdfCA1Bv0();
     } else if(CA.equals("2.0")) {
       pdfCAy = c2.setPdfCA2Bvl();
       pdfCAn = c2.setPdfCA2Bv0();
     } else if(CA.equals("3.0")) {
       pdfCAy = c2.setPdfCA3Bvl();
       pdfCAn = c2.setPdfCA3Bv0();
     }
     if(Thal.equals("normal"))
     {
       pdfTALy = c2.setPdfTalNL1();
       pdfTALn = c2.setPdfTalNL0();
     } else if(Thal.equals("fixed_defect")) {
       pdfTALy = c2.setPdfTalFD1();
       pdfTALn = c2.setPdfTalFD0();
     } else if(Thal.equals("reversible_defect")) {
       pdfTALy = c2.setPdfTalRD1();
       pdfTALn = c2.setPdfTalRD0();
     }

     pdfDy = c2.setPdfDiagnosis1();
     pdfDn = c2.setPdfDiagnosis0();

     double ansYes = pdfDy*pdfAgey*pdfSexy*pdfCPy*pdfBPy*pdfCOLy*pdfBSy*pdfRSy*pdfTHLy*pdfExy*pdfOPy*pdfSLy*pdfCAy*pdfTALy;
     double ansNo = pdfDn*pdfAgen*pdfSexn*pdfCPn*pdfBPn*pdfCOLn*pdfBSn*pdfRSn*pdfTHLn*pdfExn*pdfOPn*pdfSLn*pdfCAn*pdfTALn;
	//double percentyes = (pdfDy+pdfAgey+pdfSexy+pdfCPy+pdfBPy+pdfCOLy+pdfBSy+pdfRSy+pdfTHLy+pdfExy+pdfOPy+pdfSLy+pdfCAy+pdfTALy)/14
 //Double yes=(Double)session.getAttribute("Yes");

 
 String temp =String.valueOf(ansYes);

 System.out.println("yes servlet"+temp);

 System.out.println("yes double value "+ansYes);
 session.setAttribute("Yes",temp);

 //double YES = Double.valueOf(yes);

 
// Double no=(Double)session.getAttribute("No");
 String tempno =String.valueOf(ansNo);
	 System.out.println("no servlet"+tempno);
	 
 System.out.println("no double value "+ansNo);
 session.setAttribute("No",tempno);
 //double NO = Double.valueOf(no);

     JSONObject jso = new JSONObject();
     JSONObject jso3 = new JSONObject();

     if(ansYes>ansNo)
     {
       result = "Has heart disease";
       jso3.put("prediction",result);
       jso3.put("values",ansYes);
       jso.put("conversion",jso3);
     }
     else
     {
       result = "No heart disease";
       jso3.put("prediction",result);
       jso3.put("values",ansNo);
       jso.put("conversion",jso3);
     }
	
	 String yes1= temp;
    String no1=tempno;
	double percentyes = Double.parseDouble(yes1.substring(0,5));
	double percentno = Double.parseDouble(no1.substring(0,5));
	System.out.println("yes"+yes1);
	System.out.println("no"+no1);
	double YES2 = Double.valueOf(percentyes);
	double NO2 =Double.valueOf (percentno);
	System.out.println("Doubleyes"+yes1);
	System.out.println("Doubleno"+no1);
    final DefaultPieDataset data = new DefaultPieDataset();
    data.setValue("Has HeartDisease", new Double((YES2*10)));
    data.setValue("No HeartDisease", new Double((NO2*10)));
	System.out.println("??????? "+new Double((YES2*10)));
	System.out.println("~~~~~~~ "+new Double((NO2*10)));
    JFreeChart chart = ChartFactory.createPieChart("Heart Disease Diagnosis", data, true, true, false);
    try {
      final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());	
      final File file = new File("D:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\reports/chart.png");
	  if(file.exists()) {
		file.delete();
	  }
	  ChartUtilities.saveChartAsPNG(file, chart, 600, 400, info);
    } catch (Exception e) {
       e.printStackTrace();
    }
	 System.out.println("result"+result);
     session.setAttribute("result",result);         //for ajax response
     response.setContentType("text/xml");
     response.setHeader("Cache-Control", "no-cache");
     response.getWriter().write(jso.toString());
   }
   catch(Exception e2)
   {
     System.out.println("Exception "+e2.toString());
   }
  }
}