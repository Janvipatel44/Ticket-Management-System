package employeePerformance;

import employeePerformance.Interfaces.IFetchedPerformanceDetails;

public class FetchedPerformanceDetails implements IFetchedPerformanceDetails
{
	String startDate = null;
	String expectedEndDate = null;
	String endDate = null;
	String ticketLevel = null;
	String count = null;
	
	public FetchedPerformanceDetails(String ticketLevel, String count, String startDate, String expectedEndDate, String endDate) 
	{	
		this.ticketLevel = ticketLevel;
		this.count = count;
		this.startDate = startDate;
		this.expectedEndDate = expectedEndDate;
		this.endDate = endDate;
	}
	
	public void setTicketLevel(String ticketLevel) 
	{
    	this.ticketLevel = ticketLevel;
    }
	
	public void setCount(String count) 
	{
    	this.count = count;
    }
	
	public void setStartDate(String startDate) 
    {
        this.startDate = startDate;
    }

    public void setExpectedEndDate(String expectedEndDate)
    {
        this.expectedEndDate = expectedEndDate;
    }
    
    public void setEndDate(String endDate)
    {
        this.endDate = endDate;
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
}