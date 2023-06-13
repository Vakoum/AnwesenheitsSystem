package PreOrganized;

public class ShiftManager {

	private Shift currentShift;
	private TimeSpan currentBreak;
	private boolean employeeAttending;
	private boolean employeeTakingBreak;
	
	private TableContainer tableContainer;
	private Employee employee;
	
	public ShiftManager(TableContainer tableContainer, Employee employee) {
		this.tableContainer = tableContainer;
		this.employee = employee;
		
		employeeAttending = false;
		employeeTakingBreak = false;
	}
	public void employeeArrival() {
		if(employeeAttending == false) {
			currentShift = new Shift(getLowestShiftID(), employee.getEmployeeID());
			// give shift to Employee
			employeeAttending = true;
			// shift set startTime
		}
		else {
			System.out.println("An error Occured");
		}
	}
	public void employeeExit() {
		if(employeeAttending == true && employeeTakingBreak == false) {
			employeeAttending = false;
			//add shift to table
		}
		else {
			System.out.println("An error Occured");
		}
	}
	public void employeeStartBreak() {
		if(employeeTakingBreak == false) {
			employeeTakingBreak = true;
			//need to create timespan and give lowest availableID
			currentBreak = new TimeSpan();
			
		}
	}
	public void employeeEndBreak() {
		
	}
	//To Do
	public int getLowestShiftID() {
		return 0;
	}
}
