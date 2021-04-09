package employeePerformance;

import employeePerformance.Interfaces.IFetchedPerformanceDetails;

public class FetchedPerformanceDetails implements IFetchedPerformanceDetails
{
	String startDate = null;
	String expectedEndDate = null;
	String endDate = null;
	String ticketLevel = null;
	String count = null;
	double workingHours = 0;
	
	public FetchedPerformanceDetails(String ticketLevel, String count, String startDate, String expectedEndDate, String endDate, double workingHours) 
	{	
		this.ticketLevel = ticketLevel;
		this.count = count;
		this.startDate = startDate;
		this.expectedEndDate = expectedEndDate;
		this.endDate = endDate;
		this.workingHours = workingHours;
	}
	
	public String getStartDate() 
    {
        return startDate;
    }

    public String getExpectedEndDate()
    {
        return expectedEndDate;
    }
    
    public String getEndDate()
    {
        return endDate;
    }
    
    public String getTicketLevel()
    {
        return ticketLevel;
    }
    
    public String getCount()
    {
    	return count;
    }
    
    public double getWorkingHours()
    {
    	return workingHours;
    }
}