import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteRecord_MySQL 
{
	public static void main(String[] args)
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?characterEncoding=utf8", "root", "null");
			
			String query = "DELETE FROM users WHERE id = ?";
			PreparedStatement preparedstate = connect.prepareStatement(query);
			// par(index, value);
			preparedstate.setInt(1, 2);
			
			preparedstate.execute();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
