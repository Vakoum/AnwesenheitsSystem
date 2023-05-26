package PreOrganized;

import java.sql.Connection;
import java.sql.DriverManager;

public class ObjectsFromDatabase {
	
	String databaseName;
	Connection connection;
	
	public ObjectsFromDatabase(String databaseName) {
		try {
			this.databaseName = databaseName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, "root", "");
		}
		catch(Exception e){
			System.out.println("Couldnt Connect To Database: " + e);
		}
	}
	
	
	
	
	public void CreateConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/" + databaseName, "root", "");
		}
		catch(Exception e){
			System.out.print("Failed closing Connection: " + e);
		}
	}
	public void CloseConnection() {
		try {
			connection.close();
		}
		catch(Exception e){
			System.out.print("Failed closing Connection: " + e);
		}
	}
}
