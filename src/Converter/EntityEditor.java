package Converter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class EntityEditor<T> {
	private Connection connection;

    public EntityEditor() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/anwesensheitssystem", "root", "");
        } catch (Exception e) {
            System.out.println("Could not connect to the database - Error: " + e);
        }
    }

    //Creates new Object and needs a new ID
    public void insertEntity(T entity) {
        String sqlCommand = getInsertCommand();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            setInsertStatementValues(statement, entity);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error executing insert command: " + e);
        }
    }
    // looks for an object with an allready determined ID
    public void updateEntity(T entity) {
    	String sqlCommand = getInsertCommand();
        try {
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            setInsertStatementValues(statement, entity);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error executing insert command: " + e);
        }	
    }


    
    public void deleteEntity(T entity) {
        String sqlCommand = getDeleteCommand(entity);
        try {
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error executing delete command: " + e);
        }
    }

    public abstract String getInsertCommand();
    public abstract void setInsertStatementValues(PreparedStatement statement, T entity) throws SQLException;
    public abstract String getUpdateCommand();
    public abstract void setUpdateStatementValues(PreparedStatement statement, T entity) throws SQLException;
    public abstract String getDeleteCommand(T entity);

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error closing database connection: " + e);
        }
    }
}
