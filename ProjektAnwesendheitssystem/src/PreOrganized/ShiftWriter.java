package PreOrganized;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ShiftWriter extends DatabaseEntityWriter<Shift>{
	
	@Override
	public String getInsertCommand() {
		return "INSERT INTO shift(shiftID, shiftStart, shiftEnd, employeeID) values(?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Shift shift) throws SQLException {
		statement.setInt(1, shift.getShiftID());
		statement.setTimestamp(2, TimeConverter.localtimeToTimestamp(shift.getShiftStart()));
		statement.setTimestamp(3, TimeConverter.localtimeToTimestamp(shift.getShiftEnd()));
		statement.setInt(4, shift.getEmployeeID());
	}
	
	@Override
	public String getDeleteCommand(Shift shift) {
		return "DELETE FROM shift where shiftID = " + shift.getShiftID();
	}
}
