package employeePerformance.Interfaces;

import java.text.ParseException;
import java.util.ArrayList;

public interface IEmployeePerformanceDB 
{
	public ArrayList<String> getticketCountsDB() throws ParseException;
	public ArrayList<String> getemployeeEfficiencyDB() throws ParseException;
	public ArrayList<String> getemployeeProductivityDB() throws ParseException;
}
