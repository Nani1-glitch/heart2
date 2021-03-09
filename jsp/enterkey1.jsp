<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" session="true" %>
<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>

<html>
<head>
<title>Chart JSP Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<script type="text/javascript">

</script>
</head>
<body>

 <form action="listreports.jsp" method="post">
 <br><br><br><br><br><br>
 <div align="left"> 
 <%
HttpSession ses1=request.getSession();
 String username=ses1.getAttribute("username").toString(); 
 //ses1.setAttribute("filename",filename);
 //String filename=request.getQueryString();
 ses1.setAttribute("username",username);

%>
 <input type="password" name="pass"/>
 <input type="submit" value="submit"/>
 </div>
 </form>
</body>
</html>
