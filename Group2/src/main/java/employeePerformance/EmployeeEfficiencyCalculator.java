package employeePerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;

public class EmployeeEfficiencyCalculator implements IEmployeeEfficiencyCalculator
{
	ResultSet resultSetEfficiency = null;
	ResultSet resultSetProductivity = null;

	public EmployeeEfficiencyCalculator(ResultSet resultSet) 
	{
		this.resultSetEfficiency = resultSet;
		this.resultSetProductivity = resultSet;
	}

	public HashMap<Integer,Integer> calculateEmployeeEfficiency() throws SQLException, ParseException
	{ 
		WorkWeights myVar = null; 
		int efficiency = 0;
		int avg_efficiency = 0;
		int count = 0;
		int countMonth = 0;
		int avgEfficiency = 0;
		int month = 0;
		int year = 0;
		HashMap<Integer,Integer> EfficiencyHashMap=new HashMap<Integer,Integer>();//Creating HashMap    
		LocalDate startDate = null;
		LocalDate expectedendDate = null;
		LocalDate endDate = null;
		long durationTaken = 0;
		long durationGiven = 0;
		float divisor = 0.0f;
        float dividend = 0.0f;
        float averageResolutionTime = 0.0f;
        long differenceInSeconds;
        float differenceInTime;
        float toSeconds = 1000.0f;
        float toMinutes = 60.0f;
        float toHours = 60.0f;
        int hoursNotIncludedInWorkOnADay = 16;
        int hoursInADay = 24;
        float remainingHours;
        
		while(resultSetEfficiency.next()) 
    	{
        	
            startDate = LocalDate.parse(resultSetProductivity.getString("startDate"));
    	    expectedendDate = LocalDate.parse(resultSetProductivity.getString("endDate"));
    	    
    	       	    
    	    durationGiven = ChronoUnit.DAYS.between(startDate,expectedendDate);
    	    System.out.print("\nDifference duration Given:" +durationGiven);

    	    endDate = LocalDate.parse(resultSetEfficiency.getString("endDate"));
    	    durationTaken = ChronoUnit.DAYS.between(startDate,endDate);
    	    
    	    System.out.print("\nDifference duration taken:" +durationTaken);
    	    durationTaken++;
    	    durationGiven++;
    	    
    	    
	    	if(durationTaken < ((int) durationGiven/2)) {
    	    	if(durationGiven>10) {
    	    		myVar = WorkWeights.HIGH;
    	    	}
    	    	
    	    	else if(durationGiven>5 && durationGiven<11) {
    	    		myVar =  WorkWeights.MEDIUM; 
    	    	}
    	    	else {
    	    		myVar = WorkWeights.LOW; 
    	    	}
	    		efficiency= (int) ((durationTaken*100*myVar.getWorkWeights())/durationGiven);
    	    	System.out.print("\nEfficiency:" +efficiency);
	    	}
	    	else 
	    	{
	    		efficiency= (int) ((durationTaken*100)/durationGiven);
	    		System.out.print("\nEfficiency:" +efficiency);
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