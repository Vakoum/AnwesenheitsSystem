package Break;

import java.sql.ResultSet;
import java.time.LocalDateTime;

import Converter.EntityRetriever;
import Converter.TimeConverter;

public class BreakRetriever extends EntityRetriever<Break> {
	String sqlCommand = "Select employeeID, firstName, lastName, password, is_Admin FROM employee";
	
	@Override
	public Break convert(ResultSet resultSet) throws Exception{
		int breakID = resultSet.getInt("breakID");
		LocalDateTime breakStart = TimeConverter.timestampToLocaltime(resultSet.getTimestamp("breakStart"));
		LocalDateTime breakEnd = TimeConverter.timestampToLocaltime(resultSet.getTimestamp("breakEnd"));
		int shiftID = resultSet.getInt("shiftID");
		
		return new Break(breakID, breakStart, breakEnd, shiftID);
	}
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
}
