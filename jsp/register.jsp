<%@ page contentType="text/html; charset=iso-8859-1" language="java" import="java.sql.*" errorPage="" session="true" %>
<html>
<head>
<title>Registration Form</title>
<script type="text/javascript" src="script/heart.js"></script>
<script language="JavaScript">

function log1()
{
 var username=document.registerform.username.value;
 if(username==""){
   document.registerform.username.focus();
 }
}
function log2()
{
var len = document.registerform.password.value.length;
 var b=document.registerform.password.value;
 if(b== ""){
  alert("Enter Password");
   document.registerform.password.focus();
   
 }
}
function log3()
{
 var d=document.registerform.password.value;
 var c=document.registerform.confirmpassword.value;
 if(c!==d){
  alert("Retype Password");
   document.registerform.password.focus();
   
if(c=="")
{
  document.registerform.password.focus();
  alert("Confirm Password");
 }
 }
}
function log4()
{
 var b=document.registerform.hintquestion.value;
 if(b== ""){
  alert("Select Hintquestion");
   document.registerform.hintquestion.focus();

 }
}
function log5()
{
 var b=document.registerform.hintanswer.value;
 if(b== ""){
  alert("Select Hintanswer");
   document.registerform.hintanswer.focus();

 }
}
function log6()
{
 var a=document.registerform.terms.value;
 if(a==""){
  alert("not OK");
   document.registerform.terms.focus();
   
 }
}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" >

<table width="760" border="0" cellspacing="0" cellpadding="0" align="center" >
  <tr>
    <td height="360" valign="middle">
<form name="registerform" id="registerform">
<table width="100%" border="0" cellspacing="0" cellpadding="3" align="center" class="style4">
<tr>
<td colspan="2" bgcolor="#CCCCCC"><span class="style3">Account Information</span></td>
</tr>
<tr>
    <td width="40%" align="right">Username&nbsp;<span class="red">*</span></td>
    <td width="60%" align="left"><input type="text" name="username" onFocus="javascript:log1()"></td>
</tr>

<tr>
    <td width="40%" align="right">Password&nbsp;<span class="red">*</span></td>
    <td width="60%" align="left"><input type="password" name="password" onFocus="javascript:log1()"></td>
</tr>

<tr>
    <td width="40%" align="right">Confirm Password&nbsp;<span class="red">*</span></td>
    <td width="60%" align="left"><input type="password" name="confirmpassword" onFocus="javascript:log2()"></td>
</tr>

<tr>
    <td width="40%" align="right">Hint Question&nbsp;<span class="red">*</span></td>
    <td width="60%" align="left"><select name="hintquestion" onFocus="javascript:log3()">
	<option value="" selected>[Select Question]</option>
	<option value="father name">What is your father's middle name?</option>
	<option value="school name">What is your first school name?</option>
	<option value="childhood hero">Who was your childhood hero? </option>
	<option value="favourate pasttime">What is your favourate pasttime?</option>
	<option value="pet name">What is your pet's name</option>
	</select></td>
</tr>

<tr>
    <td width="40%" align="right">Hint Answer&nbsp;<span class="red">*</span></td>
    <td width="60%" align="left"><input type="text" name="hintanswer" onFocus="javascript:log4()"></td>
</tr>
<tr>
<td colspan="2" bgcolor="#CCCCCC"><span class="style3">Contact Information</span></td>
</tr>
<tr>
    <td width="50%" align="right">Firstname&nbsp;</td>
    <td width="50%" align="left"><input type="text" name="firstname" onFocus="javascript:log5()"></td>
  </tr>
  <tr>
    <td width="50%" align="right">Lastname&nbsp;</td>
    <td width="50%" align="left"><input type="text" name="lastname"></td>
  </tr>
  <tr>
    <td width="50%" align="right">Address1&nbsp;</td>
    <td width="50%" align="left"><input type="text" name="address1"></td>
  </tr>
  <tr>
    <td width="50%" align="right">Address2&nbsp;</td>
    <td width="50%" align="left"><input type="text" name="address2"></td>
  </tr>
  <tr>
    <td width="50%" align="right">Telephone&nbsp;</td>
	<td width="50%" align="left"><input type="text" name="telephone"><span class="lightGreyText">(Only Mobile Numbers)</span></td>
  </tr>
  <tr>
    <td width="50%" align="right">City&nbsp;</td>
    <td width="50%" align="left"><select name="city">
                  <option value="" selected>[Select City]</option>
                  <option value="Ahmedabad">Ahmedabad</option>
                  <option value="Bangalore">Bangalore</option>
                  <option value="Chennai">Chennai</option>
                  <option value="Delhi">Delhi</option>
                  <option value="Gurgaon">Gurgaon</option>
                  <option value="Hyderabad">Hyderabad</option>
                  <option value="Kolkata">Kolkata</option>
                  <option value="Mumbai">Mumbai</option>
                  <option value="Noida">Noida</option>
                  <option value="Pune">Pune</option>
                  <option value="Agartala">Agartala</option>
                  <option value="Agra">Agra</option>
                  <option value="Ahmednagar">Ahmednagar</option>
                  <option value="Aizawal">Aizawal</option>
                  <option value="Ajmer">Ajmer</option>
                  <option value="Aligarh">Aligarh</option>
                  <option value="Allahabad">Allahabad</option>
                  <option value="Ambala">Ambala</option>
                  <option value="Amritsar">Amritsar</option>
                  <option value="Anand">Anand</option>
                  <option value="Ankleshwar">Ankleshwar</option>
                  <option value="Asansol">Asansol</option>
                  <option value="Aurangabad">Aurangabad</option>
                  <option value="Bahgalpur">Bahgalpur</option>
                  <option value="Bareilly">Bareilly</option>
                  <option value="Baroda">Baroda</option>
                  <option value="Belgaum">Belgaum</option>
                  <option value="Bellary">Bellary</option>
                  <option value="Bharuch">Bharuch</option>
                  <option value="Bhatinda">Bhatinda</option>
                  <option value="Bhavnagar">Bhavnagar</option>
                  <option value="Bhilaigarh">Bhilaigarh</option>
                  <option value="Bhopal">Bhopal</option>
                  <option value="Bhubaneshwar">Bhubaneshwar</option>
                  <option value="Bhuj">Bhuj</option>
                  <option value="Bidar">Bidar</option>
                  <option value="Bilaspur">Bilaspur</option>
                  <option value="Bokaro">Bokaro</option>
                  <option value="Calicut">Calicut</option>
                  <option value="Chandigarh">Chandigarh</option>
                  <option value="Coimbatore">Coimbatore</option>
                  <option value="Cuttack">Cuttack</option>
                  <option value="Dalhousie">Dalhousie</option>
                  <option value="Daman">Daman</option>
                  <option value="Dehradun">Dehradun</option>
                  <option value="Dhanbad">Dhanbad</option>
                  <option value="Dharamsala">Dharamsala</option>
                  <option value="Dharwad">Dharwad</option>
                  <option value="Dispur">Dispur</option>
                  <option value="Durgapur">Durgapur</option>
                  <option value="Ernakulam">Ernakulam</option>
                  <option value="Erode">Erode</option>
                  <option value="Faizabad">Faizabad</option>
                  <option value="Faridabad">Faridabad</option>
                  <option value="Gandhinagar">Gandhinagar</option>
                  <option value="Gangtok">Gangtok</option>
                  <option value="Ghaziabad">Ghaziabad</option>
                  <option value="Goa">Goa</option>
                  <option value="Gorakhpur">Gorakhpur</option>
                  <option value="Gulbarga">Gulbarga</option>
                  <option value="Guntur">Guntur</option>
                  <option value="Guwahati">Guwahati</option>
                  <option value="Gwalior">Gwalior</option>
                  <option value="Haldia">Haldia</option>
                  <option value="Hisar">Hisar</option>
                  <option value="Hosur">Hosur</option>
                  <option value="Hubli">Hubli</option>
                  <option value="Imphal">Imphal</option>
                  <option value="Indore">Indore</option>
                  <option value="Itanagar">Itanagar</option>
                  <option value="Jabalpur">Jabalpur</option>
                  <option value="Jaipur">Jaipur</option>
                  <option value="Jaisalmer">Jaisalmer</option>
                  <option value="Jalandhar">Jalandhar</option>
                  <option value="Jalgaon">Jalgaon</option>
                  <option value="Jammu">Jammu</option>
                  <option value="Jamnagar">Jamnagar</option>
                  <option value="Jamshedpur">Jamshedpur</option>
                  <option value="Jodhpur">Jodhpur</option>
                  <option value="Kakinada">Kakinada</option>
                  <option value="Kandla">Kandla</option>
                  <option value="Kannur">Kannur</option>
                  <option value="Kanpur">Kanpur</option>
                  <option value="Karnal">Karnal</option>
                  <option value="Kavaratti">Kavaratti</option>
                  <option value="Kharagpur">Kharagpur</option>
                  <option value="Kochi">Kochi</option>
                  <option value="Kohima">Kohima</option>
                  <option value="Kolar">Kolar</option>
                  <option value="Kolhapur">Kolhapur</option>
                  <option value="Kollam">Kollam</option>
                  <option value="Kota">Kota</option>
                  <option value="Kottayam">Kottayam</option>
                  <option value="Kulu/Manali">Kulu/Manali</option>
                  <option value="Kurnool">Kurnool</option>
                  <option value="Kurukshetra">Kurukshetra</option>
                  <option value="Lucknow">Lucknow</option>
                  <option value="Ludhiana">Ludhiana</option>
                  <option value="Madurai">Madurai</option>
                  <option value="Mangalore">Mangalore</option>
                  <option value="Mathura">Mathura</option>
                  <option value="Meerut">Meerut</option>
                  <option value="Mohali">Mohali</option>
                  <option value="Moradabad">Moradabad</option>
                  <option value="Mysore">Mysore</option>
                  <option value="Nagercoil">Nagercoil</option>
                  <option value="Nagpur">Nagpur</option>
                  <option value="Nasik">Nasik</option>
                  <option value="Nellore">Nellore</option>
                  <option value="Nizamabad">Nizamabad</option>
                  <option value="Ooty">Ooty</option>
                  <option value="Pallakad">Pallakad</option>
                  <option value="Panipat">Panipat</option>
                  <option value="Paradeep">Paradeep</option>
                  <option value="Pathankot">Pathankot</option>
                  <option value="Patiala">Patiala</option>
                  <option value="Patna">Patna</option>
                  <option value="Pondicherry">Pondicherry</option>
                  <option value="Porbandar">Porbandar</option>
                  <option value="Port Blair">Port Blair</option>
                  <option value="Puri">Puri</option>
                  <option value="Quilon">Quilon</option>
                  <option value="Raipur">Raipur</option>
                  <option value="Rajamundry">Rajamundry</option>
                  <option value="Rajkot">Rajkot</option>
                  <option value="Ranchi">Ranchi</option>
                  <option value="Rohtak">Rohtak</option>
                  <option value="Roorkee">Roorkee</option>
                  <option value="Rourkela">Rourkela</option>
                  <option value="Salem">Salem</option>
                  <option value="Shillong">Shillong</option>
                  <option value="Shimla">Shimla</option>
                  <option value="Sholapur">Sholapur</option>
                  <option value="Silchar">Silchar</option>
                  <option value="Siliguri">Siliguri</option>
                  <option value="Silvassa">Silvassa</option>
                  <option value="Srinagar">Srinagar</option>
                  <option value="Surat">Surat</option>
                  <option value="Thanjavur">Thanjavur</option>
                  <option value="Thrissur">Thrissur</option>
                  <option value="Tirunalveli">Tirunalveli</option>
                  <option value="Tirupati">Tirupati</option>
                  <option value="Tiruvananthapuram">Tiruvananthapuram</option>
                  <option value="Trichy">Trichy</option>
                  <option value="Tuticorin">Tuticorin</option>
                  <option value="Udaipur">Udaipur</option>
                  <option value="Ujjain">Ujjain</option>
                  <option value="Vadodara">Vadodara</option>
                  <option value="Valsad">Valsad</option>
                  <option value="Vapi">Vapi</option>
                  <option value="Varanasi">Varanasi</option>
                  <option value="Vellore">Vellore</option>
                  <option value="Vijayawada">Vijayawada</option>
                  <option value="Visakhapatnam">Visakhapatnam</option>
                  <option value="Warangal">Warangal</option>
                  </select></td>
  </tr>
  <tr>
    <td width="50%" align="right">State&nbsp;</td>
    <td width="50%" align="left"><select name="state">
<option value="" selected>[Select State]</option>
<option value="Andaman &amp; Nicobar Islands">Andaman &amp; Nicobar Islands</option> 
<option value="Andhra Pradesh">Andhra Pradesh</option> 
<option value="Arunachal Pradesh">Arunachal Pradesh</option> 
<option value="Assam">Assam</option> 
<option value="Bihar">Bihar</option> 
<option value="Chandigarh">Chandigarh</option> 
<option value="Chattisgarh">Chattisgarh</option> 
<option value="Dadra &amp; Nagar Haveli">Dadra &amp; Nagar Haveli</option> 
<option value="Delhi">Delhi</option> 
<option value="Daman &amp; Diu">Daman &amp; Diu</option>
<option value="Goa">Goa</option> 
<option value="Gujarat">Gujarat</option> 
<option value="Haryana">Haryana</option> 
<option value="Himachal Pradesh">Himachal Pradesh</option> 
<option value="Jammu &amp; Kashmir">Jammu &amp; Kashmir</option> 
<option value="Jharkhand">Jharkhand</option> 
<option value="Karnataka">Karnataka</option> 
<option value="Kerala">Kerala</option> 
<option value="Madhya Pradesh">Madhya Pradesh</option> 
<option value="Maharashtra">Maharashtra</option> 
<option value="Manipur">Manipur</option> 
<option value="Meghalaya">Meghalaya</option> 
<option value="Mizoram">Mizoram</option> 
<option value="Nagaland">Nagaland</option> 
<option value="Orissa">Orissa</option> 
<option value="Pondicherry">Pondicherry</option> 
<option value="Punjab">Punjab</option> 
<option value="Rajasthan">Rajasthan</option>
<option value="Sikkim">Sikkim</option> 
<option value="Tamil Nadu">Tamil Nadu</option> 
<option value="Tripura">Tripura</option> 
<option value="Uttar Pradesh">Uttar Pradesh</option> 
<option value="Uttaranchal">Uttaranchal</option> 
<option value="West Bengal">West Bengal</option>
</select></td>
  </tr>
   <tr>
    <td width="50%" align="right">Country&nbsp;</td>
    <td width="50%" align="left"><select name="country">
<option value="" selected>[Select Country]</option>
<option value="Argentina">Argentina</option>
<option value="Australia">Australia</option>
<option value="Bahrain">Bahrain</option>
<option value="Bangladesh">Bangladesh</option>
<option value="Belgium">Belgium</option>
<option value="Canada">Canada</option>
<option value="China">China</option>
<option value="Doha">Doha</option>
<option value="Dubai">Dubai</option>
<option value="Egypt">Egypt</option>
<option value="France">France</option>
<option value="Germany">Germany</option>
<option value="Gulf">Gulf</option>
<option value="Hong Kong">Hong Kong</option>
<option value="India">India</option>
<option value="Indonesia">Indonesia</option>
<option value="Ireland">Ireland</option>
<option value="Italy">Italy</option>
<option value="Japan">Japan</option>
<option value="Jordan">Jordan</option>
<option value="Kenya">Kenya</option>
<option value="Kuwait">Kuwait</option>
<option value="Lebanon">Lebanon</option>
<option value="Libya">Libya</option>
<option value="Malaysia">Malaysia</option>
<option value="Maldives">Maldives</option>
<option value="Mauritius">Mauritius</option>
<option value="Mexico">Mexico</option>
<option value="Nepal">Nepal</option>
<option value="Netherlands">Netherlands</option>
<option value="New Zealand">New Zealand</option>
<option value="Norway">Norway</option>
<option value="Oman">Oman</option>
<option value="Pakistan">Pakistan</option>
<option value="Philippines">Philippines</option>
<option value="Qatar">Qatar</option>
<option value="Quilon">Quilon</option>
<option value="Russia">Russia</option>
<option value="Saudi Arabia">Saudi Arabia</option>
<option value="Singapore">singapore</option>
<option value="South Africa">South Africa</option>
<option value="South Korea">South Korea</option>
<option value="Spain">Spain</option>
<option value="Sri Lanka">Sri Lanka</option>
<option value="Sweden">Sweden</option>
<option value="Switzerland">switzerland</option>
<option value="Thailand">Thailand</option>
<option value="UAE">United Arab Emirates</option>
<option value="UK">United Kingdom</option>
<option value="US">United States</option>
<option value="Yemen">Yemen</option>
<option value="Zimbabwe">Zimbabwe</option>
</select></td>
</tr>
  <tr>
    <td width="50%" align="right">ZipCode&nbsp;</td>
    <td width="50%" align="left"><input type="text" name="zipcode"></td>
  </tr>
  <tr>
<td colspan="2" bgcolor="#CCCCCC"><span class="style3">Register Verification</span></td>
</tr>
<tr> 
<td align="left" colspan="2"><input type="checkbox" tabindex="20" name="terms" id="terms" value="checkbox" onSelect="javascript:log6()" /><label for="terms"><font face="Times New Roman, Times, serif" color="#666666" size="3" style="bold">I have read and I agree to the</font></label>&nbsp;<a href="http://www.pantechsolutions.net/contactus.html">terms of service</a><div align="right">* indicates mandatory field</div></td>
</tr>
<tr>
<td align="center" colspan="2"><input type="button" value="Submit Form" name="submit" onClick="javascript:getRegisterProcess();"><input type="reset" value="Clear Form" name="clear" onClick="destroy()"></td>
</tr>
</table>
</form>
</td>
  </tr>
</table>
</body>
</html>
