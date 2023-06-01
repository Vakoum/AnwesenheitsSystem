package PreOrganized;

import java.sql.ResultSet;

public class ShiftConverter extends EntityConverter<Shift>{

	String sqlCommand = "";
	
	@Override
	public Shift convert(ResultSet resultSet) throws Exception{
		//CreateSQL Stuff
		
		return new Shift();
	}
	
	@Override
	protected String getSQLCommand() {
		return sqlCommand;
	}
}
