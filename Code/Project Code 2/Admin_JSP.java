package pack;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin_JSP
 */
@WebServlet("/Admin_JSP")
public class Admin_JSP extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_JSP() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection connection = null;

		String username=request.getParameter("username1");
		System.out.println("username.........." +username);
		
		try {
			connection = DriverManager
			.getConnection("jdbc:mysql://localhost:3306/pegasus","root", "Kiran86");
			
			PreparedStatement statement2 = connection.prepareStatement("update appointment set status=? where username=?,room_id=?,datebooked=?,time_duration=?");

			statement2.setString(1,"Booked");
			/*statement2.setString(2,resultSet1.getString("username"));
			statement2.setInt(3,resultSet1.getInt("room_id"));
			statement2.setDate(4,resultSet1.getDate("datebooked"));
			statement2.setString(5,resultSet1.getString("time_duration"));
			statement2.executeUpdate();
			statement2.close();*/
			
			
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}
