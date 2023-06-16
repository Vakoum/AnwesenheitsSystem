package Shift;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import Converter.EntityEditor;
import Converter.TimeConverter;

public class ShiftEditor extends EntityEditor<Shift>{
		
	@Override
	public String getInsertCommand() {
		return "INSERT INTO shift(shiftID, shiftStart, shiftEnd, employeeID) values(?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, Shift shift) throws SQLException {
		statement.setInt(1, shift.getShiftID());
		statement.setTimestamp(2, TimeConverter.localtimeToTimestamp(shift.getShiftStart()));
		statement.setTimestamp(3, TimeConverter.localtimeToTimestamp(shift.getShiftEnd()));
		statement.setInt(4, shift.getEmployeeID());
	}
	@Override
	public String getUpdateCommand() {
		return "Update shift set startShift = ?, endShift = ?, employeeID = ? WHERE shiftID = ?";
	}
	
	@Override
	public void setUpdateStatementValues(PreparedStatement statement, Shift shift) throws SQLException{
		statement.setTimestamp(1, TimeConverter.localtimeToTimestamp(shift.getShiftStart()));
		statement.setTimestamp(2, TimeConverter.localtimeToTimestamp(shift.getShiftEnd()));
		statement.setInt(3, shift.getEmployeeID());
		statement.setInt(4, shift.getShiftID());
	}
	
	@Override
	public String getDeleteCommand(Shift shift) {
		return "DELETE FROM shift where shiftID = " + shift.getShiftID();
	}
}
