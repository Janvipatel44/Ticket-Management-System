package employeeEfficiency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

public interface IDisplayEmployeePerformance 
{
	public boolean displayEmployeeDetailsAndTicketCount(ResultSet resultset) throws SQLException, ParseException;
	public void displayEmployeeEfficiency(HashMap<Integer, Integer> calculatedEmployeeEfficiency);
	public void displayEmployeeProductivity(HashMap <Integer, Integer> calculatedEmployeeProductivity);
}
