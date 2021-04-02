package insertTicket;

import insertTicket.Interfaces.ICreateTicket;

public class CreateTicket implements ICreateTicket
{

	private String ticketID = null;
    private String description = null;
    private String startDate = null;
    private String expectedEndDate = null;
    private String endDate = null;
    private String reporterID = null;
    private String employeeID = null;
    private String assigneeName = null;
    private String ticketType = null;
    private String ticketStatus = null;
    private int priority = 0;
    private int urgency = 0;
    private int impact = 0;
    private String ticketLevel = null;
    private String customerID = null;
    private String customerName = null;
    private String creatorID = null;
    private String creatorName = null;
    private int rating = 0;
    private long workingHours = 0;
    private long ticketOnHoldHours = 0;
    private long ticketInProgressHours= 0;
    private String attachmentID = null;

    public String getTicketID() {
        return ticketID;
    }
    

    public String getDescription() {
        return description;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public String getExpectedEndDate() {
        return expectedEndDate;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public String getReporterID() {
        return reporterID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getAssigneeName() {
        return assigneeName;
    }
    
    public String getTicketType() {
        return ticketType;
    }
    
    public String getTicketStatus() {
        return ticketStatus;
    }
    
    public int getPriority() 
    {
    	return priority;
    }

    public int getUrgency() 
    {
    	return urgency;
    }
    
    public int getImpact() 
    {
    	return impact;
    }
    
    public String getTicketLevel() 
    {
    	return ticketLevel;
    }
  
    public String getCustomerID() 
    {
    	return customerID;
    }
  
    public String getCustomerName() 
    {
    	return customerName;
    }
    
    public String getCreatorID() 
    {
    	return creatorID;
    }
    
    public String getCreatorName() 
    {
    	return creatorName;
    }
    
    public int getRating() 
    {
    	return rating;
    }
    
    public long getWorkingHours() 
    {
    	return workingHours;
    }

    public long getTicketOnHoldHours() 
    {
    	return ticketOnHoldHours;
    }

    public long getTicketInProgressHours() 
    {
    	return ticketInProgressHours;
    }
   
    public String getAttachmentID() {
		// TODO Auto-generated method stub
		return attachmentID;
	}
    
    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public void setDescription(String description) {
        this.description= description;
    }
    
    public void setStartDate(String startDate)
    {
        this.startDate= startDate;
    }
    
    public void setExpectedEndDate(String expectedEndDate) 
    {
        this.expectedEndDate = expectedEndDate;
    }
    
    public void setEndDate(String endDate) 
    {
        this.endDate = endDate;
    }
    
    public void setReporterID(String reporterID) 
    {
        this.reporterID = reporterID;
    }

    public void setEmployeeID(String employeeID) 
    {
        this.employeeID = employeeID;
    }

    public void setAssigneeName(String assigneeName) 
    {
        this.assigneeName = assigneeName;
    }
    
    public void setTicketType(String ticketType) 
    {
        this.ticketType = ticketType;
    }
    
    
    public void setTicketStatus(String ticketStatus) 
    {
        this.ticketStatus = ticketStatus;
    }
    
    public void setPriority(int priority) 
    {
    	this.priority = priority;
    }

    public void setUrgency(int urgency) 
    {
    	this.urgency =urgency;
    }
    
    public void setImpact(int impact) 
    {
    	this.impact=impact;
    }
    
  
    

    
    
    public void setTicketLevel(String ticketLevel) 
    {
    	this.ticketLevel = ticketLevel;
    }
    
    public void setCustomeID(String customerID) 
    {
    	this.customerID = customerID;
    }
    public void setCustomerName(String customerName) 
    {
    	this.customerName = customerName;
    }
    public void setCreatorID(String creatorID) 
    {
    	this.creatorID = creatorID;
    }
    
    public void setCreatorName(String creatorName) 
    {
    	this.creatorName = creatorName;
    }
   
    public void setRating(int rating) 
    {
    	this.rating = rating;
    }
    
    public void setWorkingHours(long workingHours) 
    {
    	this.workingHours = workingHours;
    }
    
    public void setTicketOnHoldHours(long ticketOnHoldHours) 
    {
    	this.ticketOnHoldHours = ticketOnHoldHours;
    }
    
    public void setTicketInProgressHours(long ticketInProgressHours) 
    {
    	this.ticketInProgressHours = ticketInProgressHours;
    }
       
	public void setAttchmentID(String attachmentID) 
	{
    	this.attachmentID = attachmentID;
	}
}
