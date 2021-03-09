<%@page contentType="text/html" pageEncoding="UTF-8" import="java.sql.*,javax.servlet.*,javax.servlet.http.*"%>
<!DOCTYPE html>

<html>
<head>
<title>Untitled Document</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
<%
HttpSession sess=request.getSession();
//String username=sess.getAttribute("username").toString();
//sess.setAttribute("username",username);
%>
<h4 align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#990000">Contact Information</font></h4>

<form action="pages/listreports.jsp">
enter your username <input type="text" value="" name="username"/>
<input type="submit" value="click here"/>
</form>

</body>
</html>
