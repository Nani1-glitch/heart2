<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" session="true" %>
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>


<%
HttpSession ses1=request.getSession(true);
String username=request.getQueryString();
 //String username=ses1.getAttribute("username").toString(); 
 ses1.setAttribute("username",username);
 //String filename=request.getQueryString();
 //ses1.setAttribute("filename",filename);
%>

<html>
<head>
<title>Chart JSP Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script type="text/javascript">

</script>
</head>
<body>
 <form action="/HeartDisease/decryption" method="post">
 <br><br><br><br><br><br>
 <div align="middle"> 
 <input type="hidden" value="<%=username%>" />
 
 enter the secret key <input type="password" name="pass"/>
 <input type="submit" value="submit"/>
 </div>
 </form>
</body>
</html>
