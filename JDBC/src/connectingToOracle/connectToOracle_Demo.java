package connectingToOracle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;


public class connectToOracle_Demo
{

	static Class<?> Object=null;
	static Connection con =null;
	static Statement stmt=null;
	static ResultSet rs=null;
	static PreparedStatement pstmt=null;
	
	public static void main(String[] args) throws SQLException, IOException
	{
		
		//Comment
		try
		{
			Object = Class.forName("oracle.jdbc.driver.OracleDriver");		//Registering Driver Class
		}
		catch(ClassNotFoundException e)
		{
			
			e.printStackTrace();
		}
		
		System.out.println("Class contains: "+Object);
		

		
		
		
		
		
		try
		{
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521:XE","HR","oracle");		//Creating Connection
			
			if(con != null)
			{
				System.out.println("Successfully Connected to Oracle 11g.\n");
			}
			else
			{
				System.out.println("Error: Not connected to Oracle Databse!\n");
			}
			
			
			stmt= con.createStatement();																//Creating Statement
			
			String sql = "select e.employee_id, e.first_name, e.last_name, email, phone_number from EMPLOYEES e order by 1";	//SQL Query
			
			 rs = stmt.executeQuery(sql);																//Executing query, getting ResultSet
			
			int count=0;
			
			while(rs.next() && count<7)																	//Traversing ResultSet
			{
				count++;
				System.out.println(rs.getInt(1) + " "+rs.getString(2)+" "+rs.getString(3));				//Printing Data from ResultSet
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException e)
				{
					
					e.printStackTrace();
				}
			}
			
			
			
			//ResultSetMetaData
			ResultSetMetaData rsmd = rs.getMetaData();
			
			int colCount=rsmd.getColumnCount();
			
			System.out.println("\nTotal columns in this resultSet is "+colCount);
			
			
			
			
			
			//DatabaseMetaData
			DatabaseMetaData dbmd = con.getMetaData();
			
			System.out.println("\nDatabse product name is "+dbmd.getDatabaseProductName());;
			System.out.println("Databse product version is "+dbmd.getDatabaseProductVersion());
			System.out.println("Driver used is "+dbmd.getDriverName());
			System.out.println("Driver Version is "+dbmd.getDriverVersion());
			System.out.println("User logged in is "+dbmd.getUserName());
			
			
			
			//PreparedStatement
			pstmt = con.prepareStatement("select * from employees where email=?");
			pstmt.setNString(1, "DOCONNEL");
			ResultSet prs= pstmt.executeQuery();
			
			while(prs.next())																	
			{
				
				System.out.println("\n"+prs.getInt(1) + " "+prs.getString(2)+" "+prs.getString(3)+" "+prs.getString(4)+" "+prs.getString(5)+" "+prs.getString(6)+" "+prs.getString(7)+" "+prs.getString(8)+" "+prs.getString(9)+" "+prs.getString(10)+" "+prs.getString(11));				
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException e)
				{
					
					e.printStackTrace();
				}
			}
			System.out.println(); 			//Just a line break
			
			
			
			
			//ResultSet [Scrollable] :	 We can move to first/last row, or move to specified row directly.
			
			PreparedStatement pstmt2=con.prepareStatement("SELECT * FROM EMPLOYEES ORDER BY 1 DESC", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			ResultSet scrollRs=pstmt2.executeQuery();
			count=0;
			while(scrollRs.next() && count<10)
			{
				count++;
				System.out.println(scrollRs.getInt(1) + " "+scrollRs.getString(2)+" "+scrollRs.getString(3)+" "+scrollRs.getString(4)+" "+scrollRs.getString(5)+" "+scrollRs.getString(6)+" "+scrollRs.getString(7)+" "+scrollRs.getString(8)+" "+scrollRs.getString(9)+" "+scrollRs.getString(10)+" "+scrollRs.getString(11));				
				try
				{
					Thread.sleep(1200);
				}
				catch(InterruptedException e)
				{
					
					e.printStackTrace();
				}
			}
			
			scrollRs.last();
			System.out.println("\nDirectly moving to last row: ");
			System.out.println(scrollRs.getInt(1) + " "+scrollRs.getString(2)+" "+scrollRs.getString(3)+" "+scrollRs.getString(4)+" "+scrollRs.getString(5)+" "+scrollRs.getString(6)+" "+scrollRs.getString(7)+" "+scrollRs.getString(8)+" "+scrollRs.getString(9)+" "+scrollRs.getString(10)+" "+scrollRs.getString(11));
			
			scrollRs.absolute(5);
			System.out.println("\nDirectly moving to 5th row: ");
			System.out.println(scrollRs.getInt(1) + " "+scrollRs.getString(2)+" "+scrollRs.getString(3)+" "+scrollRs.getString(4)+" "+scrollRs.getString(5)+" "+scrollRs.getString(6)+" "+scrollRs.getString(7)+" "+scrollRs.getString(8)+" "+scrollRs.getString(9)+" "+scrollRs.getString(10)+" "+scrollRs.getString(11));
			
			
			
			
			
			
			
			
			//ResultSet [Updatable]
			
			
			
			
			
			//Insert Record
			PreparedStatement pInsert = con.prepareStatement("INSERT INTO COUNTRIES VALUES(?,?,?)");
			pInsert.setString(1, "PK");
			pInsert.setString(2, "Pakistan");
			pInsert.setInt(3, 3);
			
			//int pInsertRs = pInsert.executeUpdate();
			
			//System.out.println("\nInsert done, row count is "+pInsertRs);
			
			
			
			
			
			
			
			//Delete record from Table
			pInsert=con.prepareStatement("DELETE FROM JOB_HISTORY WHERE EMPLOYEE_ID=?");
			pInsert.setInt(1, 201);;
			int deleteCount=pInsert.executeUpdate();
			
			System.out.println("\nDeleteed |"+deleteCount+"| rows");
			
			
			
			
			//Storing Images
			allocateImages();
			
			
		}
		catch(SQLException e)
		{
			
			e.printStackTrace();
		}
		finally
		{
			if(rs != null)
			{
				rs.close();
			}
			
			if(stmt != null)
			{
				stmt.close();
			}
			if(con != null)
			{
				con.close();
			}
		}
		
		
		
		
	}

	
	public static void allocateImages() throws IOException
	{
		File f = new File("D:\\Multimedia\\Pictures\\Colg pics\\Friends\\sadhna sus\\fare well");
		
		File[] allFiles=f.listFiles();
		
		try
		{
			
			stmt= con.createStatement();
			rs=null;
			rs=stmt.executeQuery("SELECT EMPLOYEE_ID FROM EMPLOYEES ORDER BY 1");
			
			boolean b=rs.next();
			for(int i=0;i<allFiles.length;i++, b=rs.next())
			{
				if(b==false)
				{
					break;
				}
				int emp_id = rs.getInt(1);
				pstmt=con.prepareStatement("INSERT INTO IMAGES VALUES(?,?)");
				pstmt.setInt(1, emp_id);
				
				
				FileInputStream fs = new FileInputStream(allFiles[i]);
				
				pstmt.setBinaryStream(2, fs, fs.available());
				
				pstmt.executeUpdate();
				
				con.commit();
				
				pstmt.clearBatch();
			}
			
			return;
		}catch(Exception e)
		{
			System.out.println("here");
			e.printStackTrace();
		}
		finally
		{
			
		}
		
		
		
		
		
		
	}
}
