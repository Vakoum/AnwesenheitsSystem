package Shift;

import java.time.*;


public class Shift {
	private LocalDateTime shiftStart;
	private LocalDateTime shiftEnd;
	
	private int shiftID;
	private int employeeID;
	
	public Shift(int shiftID, int employeeID) {}
	public Shift(int shiftID, LocalDateTime shiftStart, LocalDateTime shiftEnd, int employeeID) {
		this.shiftID = shiftID;
		this.shiftStart = shiftStart;
		this.shiftEnd = shiftEnd;
		this.employeeID = employeeID;
	}
	
	public int getShiftID() {
		return shiftID;
	}
	public int getEmployeeID() {
		return employeeID;
	}

	public LocalDateTime getShiftStart() {
		return shiftStart;
	}

	public void setShiftStart(LocalDateTime shiftStart) {
		this.shiftStart = shiftStart;
	}

	public LocalDateTime getShiftEnd() {
		return shiftEnd;
	}

	public void setShiftEnd(LocalDateTime shiftEnd) {
		this.shiftEnd = shiftEnd;
	}
}
