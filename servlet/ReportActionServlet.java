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
import com.lowagie.text.Cell;
import com.lowagie.text.Chapter;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.List;
import com.lowagie.text.ListItem;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Section;
import com.lowagie.text.Table;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import javax.swing.*;
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

public class ReportActionServlet extends HttpServlet {
  HttpSession session;
  Connection con;
  String date;
  String queryString="";
  Document document;
  static String filename;
  static String time, result1;
  static String filepath;
  static String currentNo,file,docname, docno;
  static String username="";
  static String telephone,id;
  static String outString="";
  static String outString1="";
   static String outString2="";
  static Hashtable inputData2;
  Statement st;
  public void init(ServletConfig sc )throws ServletException{super.init(sc);}

   public void doGet(HttpServletRequest req,HttpServletResponse res)
   throws ServletException,IOException {
      doPost(req,res);
   }

   public void doPost(HttpServletRequest req,HttpServletResponse res)
	   throws ServletException,IOException {
	 session=req.getSession(true);
	 result1 = (String)session.getAttribute("result");
	 System.out.println("report"+result1);
     inputData2 = (Hashtable)session.getAttribute("inputData");
	 username=(String)session.getAttribute("username");
     con = DatabaseConnector.getConnection();
     filepath = getServletContext().getRealPath("reports/");
	 Calendar cal = Calendar.getInstance();
     time = cal.getTime().toString();
	
     currentNo = getCurrentNo();
	 file = currentNo+".pdf";
     filename = filepath+"\\"+file;
	 try {
		    queryString = "select * from register where username='"+username+"';";
            Statement select = con.createStatement();
            ResultSet result = select.executeQuery(queryString);
			  if(result.next())	{
				     telephone = result.getString("telephone");
					 id  = result.getString("id");
					 createPdf(filename);
					 res.setContentType("text/xml");
					 res.setHeader("Cache-Control", "no-cache");
					 session.setAttribute("filename",file);
					 session.setAttribute("username",username);
					 //outString ="http://localhost:8087/HeartDisease/encrypt/"+file;     //Current pdf file name
					// outString ="http://115.244.231.188:"+req.getLocalPort()+"/HeartDisease/pages/enterkey.jsp?"+username; 
					outString ="/HeartDisease/pages/enterkey.jsp?"+username; 
					// outString ="pages/listreports.jsp";
					 
					
		   }else {
			   outString="please check Name";
		   }
		select.close();
		result.close();
	   }catch(Exception e) {
	   	   System.out.println("Sql Exception : "+e.toString());
	   }
	   res.getWriter().write(outString);
	  //String key= JOptionPane.showInputDialog("Enter your secret key");
	  	Key key1 = generateKey();
		outString1 ="D:/Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\reports\\"+file;
		outString2 ="D:/Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\encrypt/"+file;
		session.setAttribute("report_page",outString2);
		AESEncrypter encrypter = new AESEncrypter((SecretKey)key1);	
		System.out.println("!!!!!!!!!!!!"+outString1);
		//Encrypt
		encrypter.encrypt(new FileInputStream(outString1),new FileOutputStream(outString2));
		System.out.println("encryption called");
		try {
		st=con.createStatement();
		int rs=st.executeUpdate("insert into report(username,reports) values('"+username+"','"+file+"')");
		}
		catch(Exception e){}
		finally {
		try{
		st.close();
		con.close();
		}
		catch(Exception w){}
		}

   }

 private static Key generateKey() {
 try{
		Common_DB cd=new Common_DB();
		java.sql.ResultSet rs = cd.ViewParticularData("heartdisease","register","username",username);
		if(rs.next()) {
        String keyValue=rs.getString("secret");
        Key key = new SecretKeySpec(keyValue.getBytes(), "AES");
		return key;
		}
		else {
		return null;
		}
		}
		catch(Exception e){
		return null;
		}
    }

    private static void createPdf(String filename) {
		Document document = new Document();
		Paragraph pbm = new Paragraph();
		Paragraph time1 = new Paragraph();
		Paragraph title1 = new Paragraph();
		Paragraph title2 = new Paragraph();
		Paragraph title3 = new Paragraph();
		Paragraph title4 = new Paragraph();
		Paragraph title5 = new Paragraph();
		Chapter universe;
		Section section;
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filename));
			document.open();
			title1 = new Paragraph("User Information", FontFactory.getFont(FontFactory.HELVETICA, 20, Font.BOLDITALIC, new Color(0, 0,153)));
			title2 = new Paragraph("Personal Detail", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new Color(102, 0,0)));

			time1 = new Paragraph(time);
			pbm = new Paragraph(result1);
            universe = new Chapter(title1,1);

            Table t1 = new Table(2, 3);
			t1.setBorderColor(new Color(0,0,0));
			t1.setPadding(5);
			t1.setSpacing(5);
			t1.setBorderWidth(1);

            Cell c11 = new Cell("UserId");
			t1.addCell(c11);
			c11 = new Cell(id);
			t1.addCell(c11);
			c11 = new Cell("UserName");
			t1.addCell(c11);
		    c11 = new Cell(username);
			t1.addCell(c11);
			t1.addCell("phone No");
            t1.addCell(telephone);

			title3 = new Paragraph("Report Time :", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new Color(102, 0,0)));

            title4 = new Paragraph("Entered Details:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new Color(102, 0,0)));
			Table t = new Table(2,7);
			t.setBorderColor(new Color(0, 0, 0));
			t.setPadding(5);
			t.setSpacing(5);
			t.setBorderWidth(1);

            Cell c1 = new Cell("Age");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(1)));
			c1 = new Cell("Sex");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(2)));
			c1 = new Cell("Chest Pain");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(3)));
		    c1 = new Cell("Blood Pressure");
			t.addCell(c1);
            t.addCell((String)inputData2.get(new Integer(4)));
			c1 = new Cell("Cholesterol");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(5)));
			c1 = new Cell("Blood Sugar");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(6)));
		    c1 = new Cell("Restecg");
			t.addCell(c1);
            t.addCell((String)inputData2.get(new Integer(7)));
			c1 = new Cell("Thalach");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(8)));
			c1 = new Cell("Exang");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(9)));
		    c1 = new Cell("Oldpeak");
			t.addCell(c1);
            t.addCell((String)inputData2.get(new Integer(10)));
			c1 = new Cell("Slope");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(11)));
			c1 = new Cell("CA");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(12)));
		    c1 = new Cell("Thal");
			t.addCell(c1);
            t.addCell((String)inputData2.get(new Integer(13)));
			c1 = new Cell("Height");
			t.addCell(c1);
			t.addCell((String)inputData2.get(new Integer(14)));
		    c1 = new Cell("Weight");
			t.addCell(c1);
            t.addCell((String)inputData2.get(new Integer(15)));

	        title5 = new Paragraph("Prediction Result:", FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC, new Color(102, 0,0)));
            Table t2 = new Table(2, 3);
            t2.setBorderColor(new Color(0,0,0));
            t2.setPadding(5);
            t2.setSpacing(5);
            t2.setBorderWidth(1);
            Cell c2 = new Cell("Report");
            t2.addCell(c2);
            t2.addCell(pbm);

            section = universe.addSection(title2);
			section.add(t1);

            section = universe.addSection(title3);
			section.add(time1);

            section = universe.addSection(title4);
			section.add(t);

            section = universe.addSection(title5);
			section.add(t2);

            document.add(universe);
		} catch (DocumentException de) {
			System.err.println(de.getMessage());
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		document.close();
	}


	private String getCurrentNo() {              //To get the PDF file number

		try {
			BufferedReader br = new BufferedReader( new FileReader(filepath+"\\"+"filename.txt" ));
			String line = br.readLine();
			if ( line == null ) {
				line = "0";
			}
			br.close();
			int seq = Integer.parseInt(line.trim());
			FileWriter fw = new FileWriter(filepath+"\\"+"filename.txt");
			fw.write(String.valueOf(seq + 1));
			fw.close();
			return String.valueOf(seq + 1);

		} catch (FileNotFoundException e) {
			try {
				FileWriter fw = new FileWriter(filepath+"\\"+"filename.txt");
				fw.write("0");
				fw.close();
				return "0";
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
    }
}