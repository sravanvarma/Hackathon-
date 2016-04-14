package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.mysql.jdbc.StandardSocketFactory;


/**
 * Servlet implementation class ToCheckbuttontime
 */
@WebServlet("/ToCheckbuttontime")
public class ToCheckbuttontime extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToCheckbuttontime() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String room=request.getParameter("slottime");
		System.out.println("selected room is :"+room);
	try
	{
	/*	Connection connection = null;
		connection = DriverManager
		.getConnection("jdbc:mysql://localhost:3306/pegasus","root", "Kiran86");
	
		String insertTableSQL = "INSERT INTO appointment"
				+ "(username, room_id, datebooked,time_duration) VALUES"
				+ "(?,?,?,?)";
		PreparedStatement ps = connection.prepareStatement(insertTableSQL);
		ps.setString(1,"sravan");
		ps.setInt(2,2);
		ps.setDate(3,java.sql.Date.valueOf("2016-04-28"));
		ps.setString(4,"12-13");
		System.out.println("in between");
		System.out.println("in successful condition............");*/
		
		PrintWriter out = response.getWriter();
		out.println("<h1> Requested will be Approved by Owner. You will be notified via E-Mail regarding the Confirmation. Thank you for doing business with us..!! <h1>");
	//ps.setString(3,username);
	/*ps.executeUpdate();
	ps.close();*/
		
	}
	catch(Exception e)
	{
		
	}
	}
	
	

}
