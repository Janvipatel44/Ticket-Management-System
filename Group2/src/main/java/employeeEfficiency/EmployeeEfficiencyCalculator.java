package employeeEfficiency;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class EmployeeEfficiencyCalculation 
{
	public boolean employee_Efficiency(ResultSet resultset) throws SQLException, ParseException
	{
		List<Long> standarHours = new ArrayList<Long>();
		List<Long> workingHours = new ArrayList<Long>();

		while(resultset.next()) 
    	{
    		System.out.println("\nStart Date:" +resultset.getString("startDate"));
    		System.out.println("\nEnd Date:" +resultset.getString("endDate"));
    		System.out.println("\nClose Date:" +resultset.getString("closeDate"));
    		
    	    LocalDate startDate = LocalDate.parse(resultset.getString("startDate"));
    	    LocalDate endDate = LocalDate.parse(resultset.getString("endDate"));
    	    long durationGiven = ChronoUnit.DAYS.between(startDate,endDate);
    	    standarHours.add(durationGiven);
    	    System.out.print("\nDifference duration Given:" +durationGiven);

    	    LocalDate closeDate = LocalDate.parse(resultset.getString("closeDate"));
    	    long durationTaken = ChronoUnit.DAYS.between(startDate,closeDate);
    	    workingHours.add(durationTaken);
    	    System.out.print("\nDifference duration taken:" +durationTaken);
 
    	    if(durationTaken!=durationGiven) 
    	    {
    	    	System.out.print("\nEfficiency:" +((durationTaken*100)/durationGiven)); 
    	    }
    	}
		return true;
	
	}
	
}
