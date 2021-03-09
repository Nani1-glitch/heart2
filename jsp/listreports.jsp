<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>

<h4 align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#990000">Report Information</font></h4>
<%
HttpSession sess=request.getSession();
String username=request.getParameter("username");
sess.setAttribute("username",username);
//String username=request.getParameter("pass1");
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/heartdisease","root","password");
Statement st = con.createStatement();
ResultSet rs=st.executeQuery("select * from report where username='"+username+"'");
while(rs.next()) {
%>

<hr>
<p>
<ul>
<li><a href="enterkey.jsp?<%=rs.getString("reports")%>"><font color="#3300CC"><%=rs.getString("reports")%></font></a> <br>
</ul> 
</p> 
<hr> 

<%
}
%>

</body>
</html>
