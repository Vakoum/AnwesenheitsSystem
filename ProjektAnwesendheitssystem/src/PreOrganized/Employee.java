package PreOrganized;

public class Employee {
	private int employeeID;
	private String firstName;
	private String lastName;
	private String password;
	private Double totalWorkTime;
	private boolean is_admin;
	
	public Employee(int id, String fN, String lN, String pw, boolean i_A) {
		employeeID = id;
		firstName = fN;
		lastName = lN;
		password = pw;
		//totalWorkTime = tWT;
		is_admin = i_A;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPassword() {
		return password;
	}
	public boolean getIs_admin() {
		return is_admin;
	}
	
}
