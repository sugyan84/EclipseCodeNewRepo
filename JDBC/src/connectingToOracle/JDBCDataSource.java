package connectingToOracle;

import java.sql.*;

import javax.sql.DataSource;

import oracle.jdbc.pool.OracleDataSource;

public class JDBCDataSource
{

	public static void main(String[] args) throws SQLException, InterruptedException
	{
		OracleDataSource ods = new OracleDataSource();
		
		ods.setURL("jdbc:oracle:thin:localhost:1521:xe");
		ods.setUser("HR");
		ods.setPassword("sugyan");
		
		DataSource ds = ods;
		
		Connection con= ds.getConnection();
		
		Statement stmt = con.createStatement();
		
		ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEES Where ROWNUM < 6");
		
		while(rs.next())
		{
			System.out.println("Employee Name: "+rs.getString("First_name"));
			
			Thread.sleep(500);
		}
		

	}

}
