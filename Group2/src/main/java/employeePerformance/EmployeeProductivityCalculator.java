package employeePerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import employeePerformance.Interfaces.IEmployeeProductivityCalculator;

public class EmployeeProductivityCalculator implements IEmployeeProductivityCalculator
{
	ResultSet resultSetProductivity = null;
	public EmployeeProductivityCalculator(ResultSet resultset)
	{
		// TODO Auto-generated constructor stub
		this.resultSetProductivity = resultset;
	}
 
	public HashMap<Integer,Integer> calculateEmployeeProductivity() throws SQLException, ParseException
	{
		int productivity = 0;
		int avg_productivity = 0;
		int count = 0;
		int officeHours = 8;
		int workingHours = 0;
		int avgProductivity = 0;
		HashMap<Integer,Integer> ProductivityHashMap=new HashMap<Integer,Integer>();//Creating HashMap    
		int month = 0;
		int countMonth = 0;
		LocalDate startDate = null;
		LocalDate endDate = null;
		long totalHours = 0;
		int year = 0;
		
		while(resultSetProductivity.next()) 
    	{    		
			startDate = LocalDate.parse(resultSetProductivity.getString("startDate"));
			endDate = LocalDate.parse(resultSetProductivity.getString("endDate"));
	    	workingHours = resultSetProductivity.getInt("resolutionHours");
	    	    
	    	System.out.print("\nStartDate:" +startDate);
	    	System.out.print("\nEndDate:" +endDate);
	    	System.out.print("\nWorking Hours:" +workingHours);

    	    totalHours = ChronoUnit.DAYS.between(startDate,endDate);
    	    totalHours = totalHours*officeHours;
    	    
    	    if(totalHours > workingHours) 
    	    {
    	    	productivity= (int) ((workingHours*100)/totalHours);
	    	}
	    	else 
	    	{
	    		productivity= 100;
	    	}
    	    
    	    avg_productivity +=productivity;
	    	count++;
	    	if(startDate.getMonthValue() == month || count==1)
	    	{
	    		avgProductivity +=productivity;
		    	countMonth++;
	    	}
	    	else
    	    {
	    		avgProductivity = avgProductivity/countMonth;	
	    		ProductivityHashMap.put(month, avgProductivity);
     	    	avgProductivity = 0;
    			countMonth = 0;
    			avgProductivity += productivity;
	    		countMonth++;
    	    }
	    	month = startDate.getMonthValue();
    	}
		
		year = startDate.getYear();
		avg_productivity = avg_productivity/count;
		ProductivityHashMap.put(year, avg_productivity);
		ProductivityHashMap.put(month, avgProductivity);
				
		return ProductivityHashMap;
	}
}
