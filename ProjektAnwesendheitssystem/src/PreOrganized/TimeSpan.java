package PreOrganized;
import java.time.*;

public class TimeSpan {
	private LocalTime startTimeSpan;
	private LocalTime endTimeSpan;
	
	private int timeSpanID;
	private int shiftID;
	
	public LocalTime getStartTimeSpan() {
		return startTimeSpan;
	}
	public void setStartTimeSpan(LocalTime startTimeSpan) {
		this.startTimeSpan = startTimeSpan;
	}
	public LocalTime getEndTimeSpan() {
		return endTimeSpan;
	}
	public void setEndTimeSpan(LocalTime endTimeSpan) {
		this.endTimeSpan = endTimeSpan;
	}
	public int getTimeSpanID() {
		return timeSpanID;
	}
	public void setTimeSpanID(int timeSpanID) {
		this.timeSpanID = timeSpanID;
	}
	public int getShiftID() {
		return shiftID;
	}
	public void setShiftID(int shiftID) {
		this.shiftID = shiftID;
	}
	
}
