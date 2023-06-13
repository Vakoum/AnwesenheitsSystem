package PreOrganized;

import java.sql.ResultSet;

public class TimeSpanConverter extends EntityConverter<TimeSpan>{
	String sqlCommand = "Select employeeID, firstName, lastName, password, is_Admin FROM employee";
	
	@Override
	public TimeSpan convert(ResultSet resultSet) throws Exception{
		
		
		return new TimeSpan();
	}
	
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
}
