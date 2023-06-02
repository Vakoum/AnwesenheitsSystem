package PreOrganized;

public class EmployeeManager {

	private TableContainer tableContainer;
	private EmployeeWriter employeeWriter;
	
	public EmployeeManager(TableContainer tableContainer) {
		this.tableContainer = tableContainer;
		this.employeeWriter = new EmployeeWriter();
	}
	public boolean isCorrectPassword(Employee employee, String password) {
		if(employee.getPassword() == password) {
			return true;
		}
		return false;
	}
	public boolean isAdmin(Employee employee) {
		return employee.getIs_admin();
	}
	
	public void deleteEmployee(Employee employee) {
		employeeWriter.deleteEntity(employee);
		tableContainer.updateTables();
	}
	public void createEmployee(Employee employee) {
		employee.setEmployeeID(tableContainer.getLowestID());
		employeeWriter.insertEntity(employee);
		tableContainer.updateTables();
	}
}
