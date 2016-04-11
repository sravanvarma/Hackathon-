<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*" %>
<%@ page import="pack.Blog" %>
<%@ page import="pack.ToCheckJDBC" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="Blog">
<h3> welcome to the Music Room  </h3>
<% 
out.print(request.getAttribute("servletName").toString());
%>

</form>
<script>

function myFunction() {
	var y=document.getElementById("datepicker").value;
	  var x = document.getElementById("ddlViewBy").selectedIndex;
	  x=x+1;
	    //var y=document.getElementById("datepicker").innerHTML;
		document.getElementById("dateSelected").innerHTML = "Requested for room: "+x+" on date: "+y;
		//added by me vikesh
		sessionStorage.setAttribute("room", x);
		session.setAttribute("date", y);
	var myVar = "<%= request.getAttribute("variable") %>";
	/* ToCheckJDBC t=new ToCheckJDBC();
	 String s=t.dateto();
	  out.println( String.valueOf( s )); 
	  request.setAttribute("variable", s); */
		// upto above
		for(var i=0;i<3;i++)
			{
		var btn = document.createElement("BUTTON");
	    var t = document.createTextNode("Hour: "+i);
	    
	    btn.appendChild(t);
	    btn.setAttribute("value", i);
	//    btn.addEventListener("click", funButtn);
	    
	    document.body.appendChild(btn);
  }
	}
/*  function funButtn() {
	  $(document).ready(function(){
		    $("button").click(function(){
		        var me = $(this);
		        // do whatever with me
		        alert(me.val());
		    }); 
		});  */

/* 		 var x = document.getElementById("ddlViewBy").selectedIndex;
		sessionStorage.setAttribute("room", x); */
		
</script>
<form action="Slot.jsp" method="post">

Select a Room and click the button:
 <select id="ddlViewBy" name="room" >
  <option value="1">Room 1</option>
  <option value="2" selected="selected">Room 2</option>
  <option value="3">Room 3</option>
</select>
<p>Date: <input type="date" id="datepicker" onchange="myFunction()"></p>
<!-- <p id="dateSelected"> </p> -->
<input type="submit" value="Submit" name="button">
</form>
</body>
</html>