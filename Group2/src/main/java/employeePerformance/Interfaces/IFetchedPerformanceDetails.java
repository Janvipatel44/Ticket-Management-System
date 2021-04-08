package employeePerformance.Interfaces;

public interface IFetchedPerformanceDetails 
{
	public String getStartDate();

    public String getExpectedEndDate();
    
    public String getEndDate();
    
    public String getTicketLevel();

    public String getCount();

    public void setStartDate(String startDate);
    
    public void setExpectedEndDate(String expectedEndDate);
    
    public void setEndDate(String endDate);
    	
	public void setTicketLevel(String ticketLevel);
	
	public void setCount(String count);
}