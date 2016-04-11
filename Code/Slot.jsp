<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page language="java" import="java.sql.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<body>
<center>
<p>For the Date
<%=request.getParameter("dateselected")%>
</p>
<P> Fr the Room :
<%=request.getParameter("room")%>
 </P> 
 <p>Available time slots</p>

<%
Connection connection = null;
connection = DriverManager
.getConnection("jdbc:mysql://localhost:3306/pegasus","root", "Kiran86");
//PreparedStatement statement = connection.prepareStatement("SELECT duration FROM timeslot WHERE DATE(dateb) = ?");
PreparedStatement statement = connection.prepareStatement(" select t.duration from schedule t,timeslot ts where DATE(ts.dateb) =? and t.duration!=ts.duration;");
statement.setString(1, request.getParameter("dateselected"));
ResultSet rs = statement.executeQuery();
ArrayList <String> array = new ArrayList<String>();
if(rs.next())
{
while(rs.next())
{	
	array.add(rs.getString("duration"));
%>
<!--  <form action="ToCheckbuttontime" >  -->
 <form action="DbUpdate.jsp" >
		 <input type="submit"  value="<%=rs.getString("duration")%>" name="slottime"/><br><br>
		 <%-- <input type="hidden" name="dateselected" value="<%request.getParameter("dateselected");%>"> --%>
	</form>
<%
}
}
else
{
	int j=10;
	for(int i=0;i<8;i++)
	{
		int k=j+1;
		 %>
		<form action="DbUpdate.jsp" method="post"> 
		
		<input type="submit"  value="<%=j+"-"+k%>" name="slottime"/><br><br>
<%
		j++;
	}
}
%>
<%-- <%= application.getAttribute("userna") %> --%>
<%
/* application.setAttribute("userna",application.getAttribute("userna")); */
%>
</form>
<%-- <p>For the Date</p>
<input type="text" value="<%=request.getParameter("dateselected")%>" />
<input type="text" value="<%=request.getParameter("room")%>" /> --%>

<%
application.setAttribute("datese",request.getParameter("dateselected"));
application.setAttribute("room",request.getParameter("room"));

%>
</center>
</body>
</head>
</html>