package Shift;

import java.sql.ResultSet;
import java.time.LocalDateTime;

import Converter.EntityRetriever;
import Converter.TimeConverter;

public class ShiftRetriever extends EntityRetriever<Shift> {
	String sqlCommand = "Select shiftID, shiftStart, shiftEnd, employeeID FROM shift";
	
	@Override
	public Shift convert(ResultSet resultSet) throws Exception{
		int shiftID = resultSet.getInt("shiftID");
		LocalDateTime shiftStart = TimeConverter.timestampToLocaltime(resultSet.getTimestamp("shiftStart"));
		LocalDateTime shiftEnd = TimeConverter.timestampToLocaltime(resultSet.getTimestamp("shiftStart"));
		int employeeID = resultSet.getInt("employeeID");
		
		return new Shift(shiftID, shiftStart, shiftEnd, employeeID);
	}
	
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
}
