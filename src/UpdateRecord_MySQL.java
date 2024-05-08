import java.sql.*;

public class UpdateRecord_MySQL 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?characterEncoding=utf8", "root", "null");
			
			String query = "UPDATE users SET num_points = ? WHERE first_name = ?";
			PreparedStatement preparedstate = connect.prepareStatement(query);
			preparedstate.setInt(1, 6000);
			preparedstate.setString(2, "Kevin");
			
			preparedstate.execute();
			
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
