<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome Admin 
<% 
out.print(request.getAttribute("servletName").toString());
%>
</h2>
<%
Connection connection = null;
connection = DriverManager
.getConnection("jdbc:mysql://localhost:3306/pegasus","root", "Kiran86");
//PreparedStatement statement = connection.prepareStatement("SELECT duration FROM timeslot WHERE DATE(dateb) = ?");
PreparedStatement statement = connection.prepareStatement(" select t.duration from schedule t,timeslot ts where DATE(ts.dateb) =? and t.duration!=ts.duration;");
statement.setString(1, request.getParameter("dateselected"));
%>
<table style="width:100%">
  <tr>
    <td>Sravan requested for appointment on 2016-04-22 for the slot 13-14 for room 2      
    
   <button type="button" onclick="myfubc()">Accept   </button>
    		
   
    <button type="button" onclick="myfunc()">Reject!</button>
    </td>
  </tr>
  <tr>
    <td>Architha requested for appointment on 2016-09-22 for the slot 15-16 for room 1      
    
   <button type="button" onclick="myfubc()">Accept   </button>
    		
   
    <button type="button" onclick="myfunc()">Reject!</button>
    </td>
  </tr>
 
</table>
</body>
<script type="text/javascript">
function myfubc() {
	alert('Request is Approved...!!!')
}
function myfunc() {
	alert('Request is Declined...!!!')
}
</script>
</html>