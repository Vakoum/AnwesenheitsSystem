package PreOrganized;

import java.time.*;
import java.sql.ResultSet;

public class ShiftConverter extends EntityConverter<Shift>{
	
	String sqlCommand = "Select shiftID, shiftStart, shiftEnd, employeeID";
	
	@Override
	public Shift convert(ResultSet resultSet) throws Exception{
		int shiftID = resultSet.getInt("shiftID");
		LocalDateTime shiftStart = TimeConverter.timestampToLocaltime(resultSet.getTimestamp("shiftStart"));
		LocalDateTime shiftEnd = TimeConverter.timestampToLocaltime(resultSet.getTimestamp("shiftEnd"));
		int employeeID = resultSet.getInt("employeeID");
		return new Shift(shiftID, shiftStart, shiftEnd, employeeID);
	}
	
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
}
