package connectingToSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo
{
	/**
	 * Connect to a sample database
	 */
	public static void connect()
	{
		Connection conn = null;
		try
		{
			// db parameters
			String url = "jdbc:sqlite:C:/sqlite/TutorialsSampleDB.db";
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");
			
			
			Statement st = conn.createStatement();
			
			String sql  = "select * from Students";
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next())
			{
				System.out.println(rs.getString(2));
			}

		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		finally
		{
			try
			{
				if(conn != null)
				{
					conn.close();
				}
			}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		}
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args)
	{
		connect();
	}
}
