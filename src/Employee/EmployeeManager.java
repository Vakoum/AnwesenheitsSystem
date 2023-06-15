package Employee;

public class EmployeeManager {
	
	private EmployeeRetriever employeeRetriever;
	private EmployeeEditor employeeEditor;
	
	public EmployeeManager() {
		employeeRetriever = new EmployeeRetriever();
		employeeEditor = new EmployeeEditor();
	}
	
	public boolean isCorrectPassword(Employee employee, String password) {
		if(employee.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	public boolean isAdmin(Employee employee) {
		return employee.getIs_admin();
	}

	public void createEmployee(Employee employee) {
		employee.setEmployeeID(getLowestEmployeeID());
		employeeEditor.insertEntity(employee);
	}
	
	public void deleteEmployee(Employee employee) {
		employeeEditor.deleteEntity(employee);
	}
	
	public int getLowestEmployeeID() {
		int lowestFreeID = 1;
		while(containsID(lowestFreeID)) {
			lowestFreeID++;
		}
		return lowestFreeID;
	}
	private boolean containsID(int id) {
		for(Employee employee : employeeRetriever.getEntitys()) {
			if(employee.getEmployeeID() == id) {
				return true;
			}
		}
		return false;
	}
}
