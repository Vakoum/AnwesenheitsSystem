package Employee;

import java.sql.ResultSet;

import Converter.EntityRetriever;

public class EmployeeRetriever extends EntityRetriever<Employee>{
	
	String sqlCommand = "Select employeeID, firstName, lastName, password, is_Admin FROM employee";
	
	@Override
	public Employee convert(ResultSet resultSet) throws Exception{
		int employeeID = resultSet.getInt("employeeID");
		String firstName = resultSet.getString("firstName");
		String lastName = resultSet.getString("lastName");
		String password = resultSet.getString("password");
		boolean is_Admin = resultSet.getBoolean("is_Admin");
		
		return new Employee(employeeID, firstName, lastName, password, is_Admin);
	}
	
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
}
