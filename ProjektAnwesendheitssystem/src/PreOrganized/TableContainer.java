package PreOrganized;

import java.util.*;


public class TableContainer {
	private List<Employee> employeeList;
	private List<Shift> shiftList;
	private List<TimeSpan> timeSpanList;
	
	private EmployeeConverter employeeConverter;
	private ShiftConverter shiftConverter;
	private TimeSpanConverter timeSpanConverter;
	
	public TableContainer() {
		employeeList = new ArrayList<Employee>();
		shiftList = new ArrayList<Shift>();
		timeSpanList = new ArrayList<TimeSpan>();
		
		employeeConverter = new EmployeeConverter();
		shiftConverter = new ShiftConverter();
		timeSpanConverter = new TimeSpanConverter();
	}
	
	public void distributeShifts() {
		for(Employee employee : employeeList) {
			for(Shift shift : shiftList) {
				if(employee.getEmployeeID() == shift.getEmployeeID()) {
					employee.getShiftList().add(shift);
				}
			}
		}
	}
	public void updateTables() {
		employeeList = employeeConverter.getEntitys();
		shiftList = shiftConverter.getEntitys();
		distributeShifts();
	}
	
	public int getLowestID() {
		int lowestFreeID = 1;
		while(containsID(lowestFreeID)) {
			lowestFreeID++;
		}
		return lowestFreeID;
	}
	private boolean containsID(int id) {
		for(Employee employee : employeeList) {
			if(employee.getEmployeeID() == id) {
				return true;
			}
		}
		return false;
	}

	
	public List<Employee> getEmployeeList(){
		return employeeList;
	}
	public List<Shift> getShiftList(){
		return shiftList;
	}
}
