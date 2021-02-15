package mavenmysql;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class mysql
{
	//sample maven app

	public static void main(String args[])
	{
		Connection con = null;
		ResultSet rs;
		try {
			Statement stmt;
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/book","root","root@123");
			stmt = con.createStatement();
			rs = stmt.executeQuery("select * from book_data");
			System.out.println("Available books are:");
			System.out.println("Id \t\t Name \t\t AuthorName \t\t genre \t\t quantity");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t\t"+rs.getString(2)+"\t\t"+rs.getString(3)+"\t\t"+rs.getString(4)+"\t\t"+rs.getString(5));
			}
		}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
				
			}
			try
			{
				con.close();
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
