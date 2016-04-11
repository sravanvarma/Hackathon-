<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<% 
//out.print(request.getAttribute("servletName").toString());
String val=request.getAttribute("servletName").toString();
application.setAttribute("userna", request.getAttribute("servletName").toString());

%>
<form action="Slot.jsp" method="post">
Select a Room and click the button:			
 <select id="ddlViewBy" name="room" >
  <option value="1">Room 1</option>
  <option value="2" selected="selected">Room 2</option>
  <option value="3">Room 3</option>
</select>
<p>Date: <input type="date" id="datepicker" name="dateselected"></p>
<%-- <input type="button" value="<%request.getAttribute("servletName").toString();%>" > --%>
<input type="submit" value="Submit" name="button">

</form>
</center>
</body>
</html>