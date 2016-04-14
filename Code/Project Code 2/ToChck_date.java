package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToChck_date
 */
@WebServlet("/ToChck_date")
public class ToChck_date extends HttpServlet {
	private static final long serialVersionUID = 1L;
     public ToChck_date() {
        super();
           }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String act = request.getParameter("act");
		String room=request.getParameter("room");
		System.out.println("selected room is :"+room);
		if (act == null) {
		    //no button has been selected
		} else if (act.equals("delete")) {
		   System.out.println("delete button got selected");
		} else if (act.equals("update")) {
		    System.out.println("update button seleected");
		} else {
		    //someone has altered the HTML and sent a different value!
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/pegasus","root", "Kiran86");
			
			PreparedStatement statement = connection.prepareStatement("select duration,value from timeslot");    
			//statement.setString(1, "manikanta"); 
			System.out.println("After query");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				
				String slot=resultSet.getString("duration");
				int id=resultSet.getInt("value");
				if(act.equals("update"))
				{
					PreparedStatement ps = connection.prepareStatement(
						      "UPDATE timeslot SET status=  ? WHERE value = ? ");
					
					ps.setString(1,"booked");
					ps.setInt(2,2);
					System.out.println("in between");
					System.out.println("in successful condition............");
		
				ps.executeUpdate();
				ps.close();
					
				}
				
				
				
			}
					
		
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

			PrintWriter out = response.getWriter(  ); 
	    response.setContentType("text/html"); 

	    try{
	    PreparedStatement statement1 = connection.prepareStatement("select duration,value,status from timeslot where status=?");    
		statement1.setString(1, "booked"); 
		System.out.println("After query");
		ResultSet resultSet1 = statement1.executeQuery();
		while(resultSet1.next())
		{
			System.out.println("in while condition");
			String slot=resultSet1.getString("duration");
			System.out.println("slot"+slot);
			int id=resultSet1.getInt("value");
            String status=resultSet1.getString("status"); 
            System.out.println("status from the db"+status);
            /*PrintWriter out1 = response.getWriter(  ); */
            response.setContentType("text/html"); 
            out.println("<H1>Hello from a Servlet</h2>"); 
                   
            
		}

	    }
	    catch(Exception e)
	    {
	    	
	    }
		
	}

}
