package employeePerformance.Interfaces;

import java.text.ParseException;

public interface IEmployeePerformanceDB 
{
	public boolean getticketCountsDB() throws ParseException;
	public boolean getemployeeEfficiencyDB() throws ParseException;
	public boolean getemployeeProductivityDB() throws ParseException;
}
