package PreOrganized;

import java.sql.*;


//Before and after using this class create- and close connection need to be called
public class DatabaseToObjects {
	
	private String tableName;
	private Connection connection;
	
	public DatabaseToObjects(String tableName) {
		try {
			this.tableName = tableName;
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/anwesensheitssystem", "root", "");
		}
		catch(Exception e){
			System.out.println("Couldnt Connect To Database: " + e);
		}
	}
	
	/*
	public int getFreeID() {
		
		ResultSet resultSet = getResultSet();
		try {
			int rowCount = 0;
			if(resultSet.last()) {
				rowCount = resultSet.getRow();
				resultSet.beforeFirst();
			}
			for(int i = 0; i< rowCount; i++) {
			}
		}
		catch(Exception e) {
			System.out.println("Could not connect to table: " + e);
		}
		return 0;
	}
	*/
	
	public String[] getColumnNames() {
		ResultSet resultSet = getResultSet(); 
		try {			
			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			
			String[] columnNames = new String[columnCount];
			
			for (int i = 1; i <= columnCount; i++) {
				columnNames[i] = metaData.getColumnName(i);				
			}
			return columnNames;
		}
		catch(Exception e) {
			System.out.println("Could not connect to table: " + e);
			return new String[0];
		}
	}
	
	public Object[][] getTableData(){
		try {
			ResultSet resultSet = getResultSet(); 
			
			int columnCount = resultSet.getMetaData().getColumnCount();
			int rowCount = 0;
			
			if(resultSet.last()) {
				rowCount = resultSet.getRow();
				resultSet.beforeFirst();
			}
			
			Object[][] data = new Object[rowCount][columnCount];
			
			int row = 0;
			while (resultSet.next()) {
				for (int col = 0; col < columnCount; col++) {
					data[row][col] = resultSet.getObject(col + 1);
				}
				row++;
			}
			return new Object[0][0];
		}
		catch(Exception e) {
			System.out.println("Couldnt Get data from Table: " + e);
		}
		return null;
		
	}
	
	
	public void createConnection() {
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/anwesensheitssystem", "root", "");
		}
		catch(Exception e){
			System.out.print("Failed closing Connection: " + e);
		}
	}
	public void closeConnection() {
		try {
			connection.close();
		}
		catch(Exception e){
			System.out.print("Failed closing Connection: " + e);
		}
	}
	
	
	private ResultSet getResultSet() {
		try {
			Statement statement = connection.createStatement();
			String sqlCommand = "SELECT * FROM " + tableName;
			ResultSet resultSet = statement.executeQuery(sqlCommand);
			return resultSet;
		}
		catch(Exception e) {
			System.out.println("Could not get ResultSet: " + e);
			return null;
		}
	}
}
