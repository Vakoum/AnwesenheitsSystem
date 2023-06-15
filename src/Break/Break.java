package Break;

import java.time.*;

public class Break {
	private LocalDateTime breakStart;
	private LocalDateTime breakEnd;
	
	private int breakID;
	private int shiftID;
	
	public Break(int breakID, int shiftID) {
		this.breakID = breakID;
		this.shiftID = shiftID;
	}
	public Break(int breakID ,LocalDateTime breakStart, LocalDateTime breakEnd, int shiftID) {
		this.breakID = breakID;
		this.breakStart = breakStart;
		this.breakEnd = breakEnd;
		this.shiftID = shiftID;
	}
	
	public LocalDateTime getBreakStart() {
		return breakStart;
	}
	public void setBreakStart(LocalDateTime breakStart) {
		this.breakStart = breakStart;
	}
	public LocalDateTime getBreakEnd() {
		return breakEnd;
	}
	public void setBreakEnd(LocalDateTime breakEnd) {
		this.breakEnd = breakEnd;
	}
	public int getBreakID() {
		return breakID;
	}

	public int getShiftID() {
		return shiftID;
	}
}
