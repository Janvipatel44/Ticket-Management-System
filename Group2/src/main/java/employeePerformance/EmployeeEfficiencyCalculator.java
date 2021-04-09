package employeePerformance;

import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import userinterface.IInputOutputHandler;

public class EmployeeEfficiencyCalculator implements IEmployeeEfficiencyCalculator
{
	IInputOutputHandler inputOutputHandler;
    static final int MAXIMUM_EFFICIENCY = 100; 
    static final int WORKWEIGHT_HIGH = 10;
    static final int WORKWEIGHT_MEDIUM = 5;

	public EmployeeEfficiencyCalculator(IInputOutputHandler inputOutputHandler)
	{
		this.inputOutputHandler = inputOutputHandler;
	}
	
	public HashMap<Integer,Integer> calculateEmployeeEfficiency(ArrayList<IFetchedPerformanceDetails> fetchedPerformanceDetails) throws SQLException, ParseException
	{ 
		WorkWeights myVar = null; 
		double efficiency = 0;
		int avg_efficiency = 0;
		int count = 0;
		int countMonth = 0;
		int avgEfficiency = 0;
		int month = 0;
		int year = 0;
		int i = 0;
		HashMap<Integer,Integer> EfficiencyHashMap=new HashMap<Integer,Integer>();//Creating HashMap    
		LocalDate startDate = null;
		LocalDate expectedendDate = null;
		LocalDate endDate = null;
		long durationTaken = 0;
		long durationGiven = 0; 
		 
	    for(i = 0; i < fetchedPerformanceDetails.size(); i++) 
		{
            startDate = LocalDate.parse(fetchedPerformanceDetails.get(i).getStartDate());
    	    expectedendDate = LocalDate.parse(fetchedPerformanceDetails.get(i).getExpectedEndDate());	    
    	    durationGiven = ChronoUnit.DAYS.between(startDate,expectedendDate);

    	    endDate = LocalDate.parse(fetchedPerformanceDetails.get(i).getEndDate());
    	    durationTaken = ChronoUnit.DAYS.between(startDate,endDate);
    	    
    	    durationTaken++;
    	    durationGiven++;
    	        	    
	    	if(durationTaken < ((int) durationGiven/2)) 
	    	{
    	    	if(durationGiven > WORKWEIGHT_HIGH) 
    	    	{
    	    		myVar = WorkWeights.HIGH;
    	    	}
    	    	
    	    	else if(durationGiven > WORKWEIGHT_MEDIUM) 
    	    	{
    	    		myVar =  WorkWeights.MEDIUM; 
    	    	}
    	    	else 
    	    	{
    	    		myVar = WorkWeights.LOW; 
    	    	}
	    		efficiency= ((durationTaken*100*myVar.getWorkWeights())/durationGiven);
	    	}
	    	else 
	    	{
	    		efficiency= ((durationTaken*100)/durationGiven);
	    	} 

	    	if(efficiency > 100) 
    		{
    			efficiency = 100;
    		}
	    	avg_efficiency +=efficiency; 
	    	count++;
	    
	    	if(startDate.getDayOfMonth() == (month) || count==1)
	    	{
	    	    avgEfficiency +=efficiency;
		    	countMonth++;
	    	}
	    	else
    	    {
    	    	avgEfficiency = avgEfficiency/countMonth;	
     	    	EfficiencyHashMap.put(month, avgEfficiency);
    			avgEfficiency = 0;
    			countMonth = 0;
	    		avgEfficiency += efficiency;
	    		countMonth++;
    	    }
	    	month = startDate.getDayOfMonth();
    	}
		
		year = startDate.getYear();
		avg_efficiency = avg_efficiency/count;
		
		EfficiencyHashMap.put(year, avg_efficiency);
		EfficiencyHashMap.put(month, avgEfficiency);
	
		return EfficiencyHashMap;
	}
}