package PreOrganized;

import java.sql.*;

public abstract class DatabaseEntityWriter<T> {
    private Connection connection;

    public DatabaseEntityWriter() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/anwesensheitssystem", "root", "");
        } catch (Exception e) {
            System.out.println("Could not connect to the database - Error: " + e);
        }
    }

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

    public void deleteEntity(T entity) {
        String sqlCommand = getDeleteCommand(entity);
        try {
            PreparedStatement statement = connection.prepareStatement(sqlCommand);
            setDeleteStatementValues(statement, entity);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            System.out.println("Error executing delete command: " + e);
        }
    }

    public abstract String getInsertCommand();
    public abstract void setInsertStatementValues(PreparedStatement statement, T entity) throws SQLException;
    public abstract String getDeleteCommand(T entity);
    public abstract void setDeleteStatementValues(PreparedStatement statement, T entity) throws SQLException;

    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.out.println("Error closing database connection: " + e);
        }
    }
}
