<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" %>
<html>
<head>
<title>Untitled Document</title>
<SCRIPT language="JavaScript" src="script/question.js"></SCRIPT>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
</head>
<body>
<table width="73%" height="348">
<tr>
<td width="40%" valign="middle"><form name="form2">
<table width="80%" border="0" cellspacing="0" cellpadding="5">
			      <tr>
                    <td height="30">
                  <p class="text" align="center"><span class="orangesubhead"><b>Your Heart Disease Risk</b></span><br></p>
                   </td>
          </tr>

                    <tr>
					   <td class="quest"><div id="question"></div></td>
					   <td class="quest"><div id="answer"></div></td>
                    </tr>
                    <tr>
                      <td bgcolor="#999999">
					   <div id="textbox2"></div>
					   
					  <input style="display:none" id="textbox" type="text" name="textbox" value="">
					  <input style="display:none" id="c1" type="radio" name="ck" value="1" ><div id="choice1"></div>
					  <input style="display:none" id="c2" type="radio" name="ck" value="2"><div id="choice2"></div>
					  <input style="display:none" id="c3" type="radio" name="ck" value="3"><div id="choice3"></div> 
					  <input style="display:none" id="c4" type="radio" name="ck" value="4"><div id="choice4"></div>
                      </td>
                    </tr>
                    <tr>
                      <td align="center">
                          <input style="display:none" id="nextbutton" type="button" name="ok" value="Next" maxlength="3" onClick="javascript:ajaxprocess2()">
     					  <input style="display:none" id="reportbutton" type="button" value="Click Here To Save Your Details" maxlength="3" onClick="javascript:ajaxprocess5()">
					 </td>
                  </tr>
                  </table>
	  </form>
</td>
<td width="60%">
<table width="98%" height="187" border="0" cellpadding="8" cellspacing="0">
 <tr>
   <td valign="middle">
     <p><a id="display_report" href="#" style="display:none" onClick="javascript:viewPDF();" >click reports menu to view report in PDF Format</a>
         </div>
     </p>
     <p>           <a id="display_chart" href="#" style="display:none" onClick="javascript:viewChart();">click here to view report in Chart Format</a>
           </div>
         </p>
     <p class="text"><span class="orangesubhead"><div id="details"></div></span><br></p>
   </td>
 </tr>
</table>
</td>
</tr>
</table>
</body>
</html>
