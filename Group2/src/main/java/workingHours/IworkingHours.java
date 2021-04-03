package workingHours;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface IworkingHours {
	
	public double insertTicket(ResultSet resultset) throws SQLException;
}
