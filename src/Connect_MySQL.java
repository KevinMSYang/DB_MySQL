import java.sql.*;

public class Connect_MySQL 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?characterEncoding=utf8", "root", "null");
			Statement state = connect.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM contacts");
			
			while (result.next())
			{
				System.out.println(result.getInt(1) + " " + result.getString(2));
				connect.close();
			}
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
