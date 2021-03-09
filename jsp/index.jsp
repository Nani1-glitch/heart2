<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>Medical Diagnosis</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<link href="css/style.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="script/heart.js"></script>
<script type="text/javascript" src="script/question.js"></script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="javascript:getId(1);">
<table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td height="1" background="images/bg_1.jpg"><table width="991" height="60"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td width="15"><img src="images/spacer.gif" width="15" height="1"></td>
<td width="37"><img src="images/logo.jpg" width="37" height="59"></td>
<td width="6"><img src="images/spacer.gif" width="6" height="1"></td>
<td class="logo">Heart Disease Prediction System Using Data Mining Technique</td>
<td class="logo"><img src="images/spacer.gif" width="30" height="1"></td>
<td><img src="images/im_3.jpg" width="256" height="59"></td>

<td align="right"><div id="login_button" style="display:none"><font face="Verdana, Arial, Helvetica, sans-serif" size="-1" color="#FF0066"><a href="javascript:getId(7);" style="text-decoration:none">Login</a></font></div><div id="logout_button" style="display:none"><font face="Verdana, Arial, Helvetica, sans-serif" size="-1" color="#FF0066"><a href="javascript:getId(1);" style="text-decoration:none">Logout</a></font></div></td>

</tr>
<tr bgcolor="#FFFFFF">
<td height="1" colspan="6"><img src="images/spacer.gif" width="1" height="1"></td>
</tr>
</table></td>
</tr>
<tr>
<td height="100%" valign="top"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td width="207" height="100%" valign="top"><table width="100%"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td height="143"><img src="images/im_1.jpg" width="207" height="143">
</td>
</tr>
<tr>
<td height="1"></td>
</tr>
<tr>
<td height="84" background="images/bg_2.jpg"><img src="images/spacer.gif" width="1" height="45"></td>
</tr>
<tr>
<td height="195" align="right"><img src="images/im_2.jpg" width="185" height="195"></td>
</tr>
</table></td>
<td height="100%" valign="top"><table width="100%" height="100%"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td height="2" bgcolor="#A9ABB1"><img src="images/spacer.gif" width="1" height="2"></td>
</tr>
<tr>
<td height="43" background="images/bg_4.jpg" valign="middle">
<div id="header" style="display:none">
<table width="586" height="43"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td height="6" colspan="20"><img src="images/spacer.gif" width="1" height="6"></td>
</tr>
<tr>
<td width="1"><img src="images/spacer.gif" width="1" height="1"></td>
<td width="17"><img src="images/btn_l.jpg" width="17" height="31"></td>
<td width="78" align="center" valign="middle" background="images/btn_bg.jpg"><a href="javascript:getId(2);" style="text-decoration:none">FACT SHEET</a></td>
<td width="19"><img src="images/btn_r.jpg" width="17" height="31"></td>

<td width="1"><img src="images/spacer.gif" width="1" height="1"></td>
<td width="17"><img src="images/btn_l.jpg" width="17" height="31"></td>
<td width="93" align="center" valign="middle" background="images/btn_bg.jpg"><a href="javascript:getId(3);" style="text-decoration:none">RISK FACTORS</a></td>
<td width="20"><img src="images/btn_r.jpg" width="17" height="31"></td>

<td width="1"><img src="images/spacer.gif" width="1" height="1"></td>
<td width="17"><img src="images/btn_l.jpg" width="17" height="31"></td>
<td width="92" align="center" valign="middle" background="images/btn_bg.jpg"><a href="javascript:ajaxprocess();" style="text-decoration:none">QUESTIONAIRE</a></td>
<td width="20"><img src="images/btn_r.jpg" width="17" height="31"></td>

<td width="1"><img src="images/spacer.gif" width="1" height="1"></td>
<td width="17"><img src="images/btn_l.jpg" width="17" height="31"></td>
<td width="70" align="center" valign="middle" background="images/btn_bg.jpg"><a href="javascript:getId(5);" style="text-decoration:none">CONTACTS</a></td>
<td width="20"><img src="images/btn_r.jpg" width="17" height="31"></td>

<td width="17"><img src="images/btn_l.jpg" width="17" height="31"></td>
<td width="46" align="center" valign="middle" background="images/btn_bg.jpg"><a href="javascript:getId(6);" style="text-decoration:none">ABOUT</a></td>
<td width="39"><img src="images/btn_r.jpg" width="17" height="31"></td>
</tr>
<tr>
<td height="6" colspan="20"><img src="images/spacer.gif" width="1" height="6"></td>                         
</tr>
</table>
</div>
<div id="heading" style="display:none"><marquee><h5 align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#990000">Welcome To Find Your Heart Disease Risk !</font></h5></marquee></div></td>
</tr>
<tr>
<td height="2" bgcolor="#BFC0C4"><img src="images/spacer.gif" width="1" height="2"></td>
</tr>
<tr>
<td height="1" background="images/bg_dotted.jpg"><img src="images/spacer.gif" width="1" height="1"></td>
</tr>
<tr>
<td valign="top" bgcolor="#D5D6D9"><table class="tdbgx" width="100%" height="348"  border="0" cellpadding="0" cellspacing="0" background="images/bg_6.jpg">
<tr>
<td height="16" colspan="3"><img src="images/spacer.gif" width="1" height="16"></td>
</tr>
<tr>
<td width="21"><img src="images/spacer.gif" width="21" height="1"></td>
<td width="721" valign="top">

<div id="login" style="display:none"><jsp:include page="pages/login.jsp"/></div>
<div id="register" style="display:none"><jsp:include page="pages/register.jsp"/></div>
<div id="home"><jsp:include page="pages/home.jsp"/></div>

<div id="fact" style="display:none"><jsp:include page="pages/fact.jsp"/></div>
<div id="risk" style="display:none"><jsp:include page="pages/risk.jsp"/></div>
<div id="question2" style="display:none"><jsp:include page="pages/question.jsp"/></div>
<div id="contact" style="display:none"><jsp:include page="pages/contact.jsp"/></div>
<div id="about" style="display:none"><jsp:include page="pages/about.jsp"/></div>


</td>
<td width="43"><img src="images/spacer.gif" width="42" height="1"></td>
</tr>
<tr>
<td height="5" colspan="3"><img src="images/spacer.gif" width="1" height="5"></td>
</tr>
</table></td>
</tr>
<tr>
<td height="1"><img src="images/spacer.gif" width="1" height="1"></td>
</tr>
</table></td>
</tr>
</table></td>
</tr>
<tr>
<td height="1" background="images/bg_3.jpg"><table width="100%" height="74"  border="0" cellpadding="0" cellspacing="0">
<tr>
<td align="center" valign="middle"><div id="footer" style="display:none"><font color="#000000"><a href="#" class="menu">Home</a> || <a href="#" class="menu">Fact Sheet</a> || <a href="#" class="menu">Risk Factors</a> || <a href="#" class="menu">Questionaire</a> || <a href="#" class="menu">Contacts</a></font> || <a href="#" class="menu">About Us</a></font></div>
<div id="copyright" style="display:none" align="center"><font face="Verdana, Arial, Helvetica, sans-serif" color="#990000"></font></div></td>
</tr>                                                                
</table></td>
</tr>
</table>
</body>
</html>
