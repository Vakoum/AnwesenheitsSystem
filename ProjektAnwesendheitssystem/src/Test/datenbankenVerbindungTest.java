package Test;

import java.sql.*;


//Funktion geht nur wenn man sie vorher in eclipse vorbereitet hat
public class datenbankenVerbindungTest {
	
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:mysql://localhost/anwesensheitssystem", "root", "");
			System.out.println("Databese Connected!");
			Statement statement = connection.createStatement();
			String sqlCommand = "SELECT * FROM mitarbeiter";
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			//Object data = resultSet.getObject(1);
			if(resultSet.next()){
				Object firstValue = resultSet.getObject(2);
				System.out.println(firstValue);				
			}
			
			
			connection.close();
		}
		catch(Exception e) {
			System.out.println("Do not Connect to Database - Error: " + e);
		}
	}
}
