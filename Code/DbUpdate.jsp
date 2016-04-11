<%@page import="java.text.SimpleDateFormat"%>
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
<h1> <%= application.getAttribute("userna") %> You have Requested an Appointment For Time</h1>

<%
 Connection connection = null;
connection = DriverManager
.getConnection("jdbc:mysql://localhost:3306/pegasus","root", "Kiran86");
//PreparedStatement statement = connection.prepareStatement("SELECT duration FROM timeslot WHERE DATE(dateb) = ?");
PreparedStatement statement = connection.prepareStatement(" select t.duration from schedule t,timeslot ts where DATE(ts.dateb) =? and t.duration!=ts.duration;");
statement.setString(1, request.getParameter("dateselected"));
ResultSet rs = statement.executeQuery(); 
String insertTableSQL = "INSERT INTO appointment"
		+ "(username, room_id, datebooked,time_duration) VALUES"
		+ "(?,?,?,?)";
PreparedStatement ps = connection.prepareStatement(insertTableSQL);
String nam=application.getAttribute("userna").toString();
ps.setString(1,nam);
String ro=application.getAttribute("room").toString();
int foo = Integer.parseInt(ro);
ps.setInt(2,foo);
Date date=null;
Date formatteddate = null;
SimpleDateFormat form=new SimpleDateFormat("yyyy-MM-DD");
String dateInString =application.getAttribute("datese").toString();
java.util.Date date1 = form.parse(dateInString);
java.sql.Date sqlStartDate = new java.sql.Date(date1.getDate());
ps.setDate(3,sqlStartDate);
String slt=request.getParameter("slottime").toString();
ps.setString(4,slt);
ps.executeUpdate();
ps.close();

// To Send mail
   final String SMTP_HOST_NAME = "smtp.gmail.com";
	 final String SMTP_AUTH_USER = "vikesh.ls11@gmail.com";
	  final String SMTP_AUTH_PWD  = "Vikesh@91";


%>

<%-- <%= application.getAttribute("userna") %> --%>
<p>Date : 
<%= application.getAttribute("datese") %>
</p>
<p> Time : 
 <% 
 out.print(request.getParameter("slottime")); 
 /* out.print(request.getParameter("dateselected")); */
%> 
</p>
<p> Room :
<%= application.getAttribute("room") %></p>
<form action="ToCheckbuttontime" method="post">
<!-- <button type="button" onclick="alert('You have cancelled request')">Cancel</button> -->
<button type="submit">Submit</button>
</form>
</body>
</html>