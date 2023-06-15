package Converter;

import java.sql.*;
import java.util.*;

public abstract class EntityRetriever <T>{
	
	protected abstract T convert(ResultSet resultSet) throws Exception;
	
	public List<T> getEntitys(){
		List<T> entitys = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/anwesensheitssystem", "root", "");
            Statement statement = connection.createStatement();
            
            String sqlStatement = getSQLCommand();
            ResultSet resultSet = statement.executeQuery(sqlStatement);
            
            while(resultSet.next()) {
            	T entity = convert(resultSet);
            	entitys.add(entity);
            }
            
            
            connection.close();
            }
		catch(Exception e) {
			System.out.println("Could not connect to the database - Error: " + e);
		}
		
		return entitys;
	}
	
	protected abstract String getSQLCommand();
	
}
