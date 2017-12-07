package connectingToOracle;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


/*This program demonstrates the use of JdbcRowSet. 
* (it is java bean component with properties and java bean notifiction mechanism)
*/
public class JDBCRowSet_Demo
{
	private static final String DB_URL="jdbc:oracle:thin:localhost:1521:XE";
	private static final String DB_USERNAME="HR";
	private static final String DB_PASSWORD="sugyan";
		
	public static void main(String[] args) throws SQLException, InterruptedException
	{
		RowSetFactory f = RowSetProvider.newFactory();
		JdbcRowSet j = f.createJdbcRowSet();
		
		j.setUrl(DB_URL);
		j.setUsername(DB_USERNAME);
		j.setPassword(DB_PASSWORD);
		
		j.setCommand("SELECT * FROM EMPLOYEES WHERE manager_id='124' order by 1");
		
		j.execute();
		
		while(j.next())
		{
			System.out.println("EMPID=|"+j.getInt(1)+"| EMPLOYEE_NAME=|"+j.getString(2)+" "+j.getString(3)+"|");
			Thread.sleep(1200);
		}
		
	}

}
