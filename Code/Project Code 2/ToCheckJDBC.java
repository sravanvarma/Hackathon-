package pack;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ToCheckJDBC 
{
	public static void main(String[] args) {
		
	/*	System.out.println("-------- MySQL JDBC Connection Testing ------------");

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

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("You made it, take control your database now!");
		} else {
			System.out.println("Failed to make connection!");
		}
	  }
		
*/	}
		public String details()
	{
		System.out.println("in details method of tocheck jdbc");
		String name="to check scriptlet in script";
		return name;
	}
	
		public String dateto()
		{
			System.out.println("in datetot method....");
			return "in date to method";
		}
		
		
	}
	


