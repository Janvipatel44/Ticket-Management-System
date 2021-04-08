package employeePerformance.Interfaces;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

public interface IEmployeeEfficiencyCalculator {

	public HashMap<Integer,Integer> calculateEmployeeEfficiency(ArrayList<IFetchedPerformanceDetails> fetchedPerformanceDetails)
			throws SQLException, ParseException;
	
}
