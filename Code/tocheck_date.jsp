<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<title>jQuery UI Datepicker - Default functionality</title>
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
</head>
<body>
<form method="post" action="ToChck_date">
<br/>
<input type="submit" name="act" value="delete"/>
<input type="submit" name="act" value="update"/>
</form>
<form method="post" action="ToCheckbuttontime">

 <script type="text/javascript">
  function myFunction() {
	var y=document.getElementById("datepicker").value;
	  var x = document.getElementById("ddlViewBy").selectedIndex;
	  x=x+1;
	    //var y=document.getElementById("datepicker").innerHTML;
		document.getElementById("dateSelected").innerHTML = "Requested for room: "+x+" on date: "+y;
		
		for(var i=0;i<3;i++)
			{
	    var btn = document.createElement("BUTTON");
	    var t = document.createTextNode("Hour: "+i);
	    
	    btn.appendChild(t);
	    btn.setAttribute("value", i);
	    btn.addEventListener("click", funButtn);
	    
	    document.body.appendChild(btn);
  }
	}
  function funButtn() {
	  $(document).ready(function(){
		    $("button").click(function(){
		        var me = $(this);
		        // do whatever with me
		        alert(me.val());
		    }); 
		});
	
}
  </script>
  <body>
 Select a Room and click the button:
 <select id="ddlViewBy">
  <option value="1">Room 1</option>
  <option value="2" selected="selected">Room 2</option>
  <option value="3">Room 3</option>
</select>
<p>Date: <input type="date" id="datepicker"></p>
<button onclick="myFunction()">Get Details</button>
<p id="dateSelected"> </p>
</body>



</form>
</body>
</html>