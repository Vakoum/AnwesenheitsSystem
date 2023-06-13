package PreOrganized;

import java.time.*;


public class Shift {
	private LocalDateTime shiftStart;
	private LocalDateTime shiftEnd;
	private TimeSpan[] breaks;
	
	private int shiftID;
	private int employeeID;
	
	public Shift(int shiftID, int employeeID) {}
	public Shift(int shiftID, LocalDateTime shiftStart, LocalDateTime shiftEnd, int employeeID) {
		this.shiftID = shiftID;
		this.setShiftStart(shiftStart);
		this.setShiftEnd(shiftEnd);
		this.employeeID = employeeID;
	}
	
	public int getShiftID() {
		return shiftID;
	}
	public int getEmployeeID() {
		return employeeID;
		
	}

	public TimeSpan[] getBreaks() {
		return breaks;
	}
	public void setBreaks(TimeSpan[] breaks) {
		this.breaks = breaks;
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
