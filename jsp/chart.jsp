<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" session="true" %>

<%@ page  import="java.awt.*" %>
<%@ page  import="java.io.*" %>
<%@ page  import="org.jfree.chart.*" %>
<%@ page  import="org.jfree.chart.entity.*" %>
<%@ page  import ="org.jfree.data.general.*"%>
<%@ page  import="javax.servlet.http.*"%>
<%@ page  import="javax.servlet.*"%>

<%
	/*HttpSession sess = request.getSession();
    String yes= (String)sess.getAttribute("Yes");
    String no=(String)sess.getAttribute("No");
	System.out.println("yes"+yes);
	System.out.println("no"+no);
	double YES = Double.valueOf(yes);
	double NO =Double.valueOf (no);
	System.out.println("Doubleyes"+yes);
	System.out.println("Doubleno"+no);
    final DefaultPieDataset data = new DefaultPieDataset();
    data.setValue("Has HeartDisease", new Double(YES));
    data.setValue("No HeartDisease", new Double(NO));
    JFreeChart chart = ChartFactory.createPieChart("Heart Disease Diagnosis", data, true, true, false);
    try {
      final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
      final File file = new File("D:\\Program Files\\Apache Software Foundation\\Tomcat 7.0\\webapps\\HeartDisease\\reports/chart.png");
	  ChartUtilities.saveChartAsPNG(file, chart, 600, 400, info);
    } catch (Exception e) {
        out.println(e);
    }
	*/
%>

<html>
<head>
<title>Chart JSP Page</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
 <IMG align="middle" src="../reports/chart.png" WIDTH="600" HEIGHT="400" BORDER="0" USEMAP="#chart">
</body>
</html>
