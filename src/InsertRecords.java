import java.sql.*;
import java.util.Calendar;


public class InsertRecords 
{
	public static void main(String[] args)
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase?characterEncoding=utf8", "root", "null");
			
			Calendar calendar = Calendar.getInstance();
			java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
			
			String query = "INSERT INTO users (first_name, last_name, data_created, is_admin, num_points) VALUES (?, ?, ?, ?, ?)";
			
			PreparedStatement preparedstate = connect.prepareStatement(query);
			preparedstate.setString(1, "Sherry");
			preparedstate.setString(2,"Lian");
			preparedstate.setDate(3, startDate);
			preparedstate.setBoolean(4, false);
			preparedstate.setInt(5, 5000);
			
			preparedstate.execute();
			
			Statement state = connect.createStatement();
			state.executeUpdate("INSERT INTO users (first_name, last_name, is_admin, num_points) VALUES ('Kevin', 'Yang', false, 10000)");
			
			connect.close();
		} catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
