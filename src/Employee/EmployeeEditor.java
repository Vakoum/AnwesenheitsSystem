package Employee;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Converter.EntityEditor;


public class EmployeeEditor extends EntityEditor<Employee> {
	@Override
	public String getInsertCommand() {
		return "INSERT INTO employee(employeeID, firstName, lastName, password, is_Admin) values(?,?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Employee employee) throws SQLException {
		statement.setInt(1, employee.getEmployeeID());
		statement.setString(2, employee.getFirstName());
		statement.setString(3, employee.getLastName());
		statement.setString(4, employee.getPassword());
		statement.setBoolean(5, employee.getIs_admin());
	}
	@Override
	public String getUpdateCommand() {
		return "Update employee set firstName = ?, lastName = ?, password = ?, is_Admin = ? WHERE employeeID = ?";
	}
	
	@Override
	public void setUpdateStatementValues(PreparedStatement statement, Employee employee) throws SQLException{
		statement.setString(1, employee.getFirstName());
		statement.setString(2, employee.getLastName());
		statement.setString(3, employee.getPassword());
		statement.setBoolean(4, employee.getIs_admin());
		statement.setInt(5, employee.getEmployeeID());
	}
	
	@Override
	public String getDeleteCommand(Employee employee) {
		return "DELETE FROM employee where employeeID = " + employee.getEmployeeID();
	}
}
