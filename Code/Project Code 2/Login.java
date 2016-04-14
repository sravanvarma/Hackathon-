package pack;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.StandardSocketFactory;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		request.setAttribute("servletName", username); // value assigning to send data to next page
		String dbusername;
		String dbpassword=null;
		String role=null;
		System.out.println("username"+username);
		
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

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
			
			PreparedStatement statement = connection.prepareStatement("select password,role,phone_number,login_count from admin where username = ?");    
			statement.setString(1, username); 
		//	System.out.println("After query");
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next())
			{
				dbpassword=resultSet.getString("password");
				role=resultSet.getString("role");
				String phone=resultSet.getString("phone_number");
				int i=resultSet.getInt("login_count");
			/*	System.out.println("login_count"+i);
				System.out.println("phone"+phone);
				System.out.println("password"+dbpassword);
				System.out.println("admin role"+role);*/
			}
		//System.out.println("dbpasswords"+dbpassword);
			if(password.equals(dbpassword) )
			{
			//	System.out.println("Passwords are equal");
				//page navigation
				if(role.equals("admin"))
				{
					// To Check appointment details
					PreparedStatement statement1 = connection.prepareStatement("select username,room_id,datebooked,time_duration,status from appointment where status=?");
					String sta="Available";
					statement1.setString(1, sta);
//System.out.println("To check details from the appointment table;...............................");
ResultSet resultSet1 = statement1.executeQuery();
					while(resultSet1.next())
					{
					//	System.out.println("in while statement........................");
						String name=resultSet1.getString("username");
						int room=resultSet1.getInt("room_id");;
						Date date_boo=resultSet1.getDate("datebooked");
						String time_dr=resultSet1.getString("time_duration");
						String status=resultSet1.getString("status");
						
					
						/*System.out.println("name"+name);
						System.out.println("room"+room);
						System.out.println("date"+date_boo);
						System.out.println("time_dr"+time_dr);
						System.out.println("sytatus"+status);*/
					}
					
					
					
				/*	
					getServletConfig().getServletContext().getRequestDispatcher(

					        "/Admin_Page.jsp").forward(request,response);*/
					
					getServletConfig().getServletContext().getRequestDispatcher(

					        "/Admin_check.jsp").forward(request,response);
					//System.out.println("after request sent");
				}
				
				//page navigation
				else{
					//updating status and login_count
					//to get login_count
				//	System.out.println("in password equal and not admin");
				
					PreparedStatement ps = connection.prepareStatement(
						      "UPDATE admin SET login_count = ?,status=? WHERE username = ? ");
					ps.setInt(1,0);
					ps.setString(2,"Active");
				//	System.out.println("in between");
					//System.out.println("in successful condition............");
				ps.setString(3,username);
				ps.executeUpdate();
				ps.close();
				
				/*getServletConfig().getServletContext().getRequestDispatcher(

				        "/Blog.jsp").forward(request,response);*/
				getServletConfig().getServletContext().getRequestDispatcher(

				        "/DateP.jsp").forward(request,response);
			//	System.out.println("after request sent");
				
				
				}
				
			}
			else
			{
				//updating status and login_count
				//to get login_count
			//	System.out.println("in else condition................");
				String selectSQL = "select login_count from admin where username = ?";
				/*PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1,username);
				System.out.println("in between prepare stmt"+username);
				ResultSet rs = preparedStatement.executeQuery(selectSQL );*/
				PreparedStatement statement1 = connection.prepareStatement("select phone_number,login_count,role from admin where username = ?");    
				statement1.setString(1, username); 
			//	System.out.println("After query");
				ResultSet rs1 = statement.executeQuery();
				while (rs1.next()) {
					System.out.println("in while condition......");
					int i=rs1.getInt("login_count");
					if(i==0)
					{
						
						PreparedStatement ps = connection.prepareStatement(
							      "UPDATE admin SET login_count = ? WHERE username = ? ");
						ps.setInt(1,1);
						System.out.println("in between");
						
					ps.setString(2, username);
					ps.executeUpdate();
					ps.close();
					}
					if(i==1)
					{
						
						PreparedStatement ps = connection.prepareStatement(
							      "UPDATE admin SET login_count = ? WHERE username = ? ");
						ps.setInt(1,2);
						System.out.println("in between");
						System.out.println("in second if condition.........");
					ps.setString(2, username);
					ps.executeUpdate();
					ps.close();
					}
					if(i==2)
					{
						
						PreparedStatement ps = connection.prepareStatement(
							      "UPDATE admin SET login_count = ?,status=? WHERE username = ? ");
						ps.setInt(1,3);
						ps.setString(2,"blocked");
				//		System.out.println("in between");
				//		System.out.println("in 3rd if condition............");
					ps.setString(3,username);
					ps.executeUpdate();
					ps.close();
					}

					String srole=rs1.getString("role");
					String phone=rs1.getString("phone_number");
				//	System.out.println("login count value"+i);
					//System.out.println("role "+srole);
				}
				
				request.getRequestDispatcher("Login.jsp").forward(request, response);
				//System.out.println("Please enter correct passwords");
			}
		     
			
			

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		//System.out.println("You made it, take control your database now!");
	  }
		
	}


