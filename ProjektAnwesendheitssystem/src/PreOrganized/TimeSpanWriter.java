package PreOrganized;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TimeSpanWriter extends DatabaseEntityWriter<TimeSpan>{
	
	@Override
	public String getInsertCommand() {
		return "INSERT INTO timeSpan(timeSpanID, startTimeSpan, endTimeSpan, shiftID) values(?,?,?,?)";
	}
	
	@Override
	public void setInsertStatementValues(PreparedStatement statement, TimeSpan timeSpan) throws SQLException {
		statement.setInt(1, timeSpan.getTimeSpanID());
		statement.setTimestamp(2, null);
		statement.setTimestamp(3, null);
		statement.setInt(4, timeSpan.getShiftID());
	}
	
	@Override
	public String getDeleteCommand(TimeSpan timeSpan) {
		return "DELETE FROM employee where employeeID = " + timeSpan.getTimeSpanID();
	}
	
	public void setDeleteStatementValues(PreparedStatement statement, TimeSpan timeSpan) throws SQLException{
		
	}
}
