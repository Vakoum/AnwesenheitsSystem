package PreOrganized;

public class LogIn {
	
	public boolean checkIfCorrectPassword(Employee employee, String password) {
		if(employee.getPassword() == password) {
			return true;
		}
		return false;
	}
}
