package insertTicket.Interfaces;

public interface ICreateTicket {
    
	public String getTicketID(); 
    public String getDescription();    
    public String getStartDate(); 
    public String getExpectedEndDate();
    public String getEndDate();
    public String getReporterID();
    public String getEmployeeID();
    public String getAssigneeName();
    public String getTicketType();
    public String getTicketStatus();
    public int getPriority();
    public int getUrgency();
    public int getImpact();
    public String getTicketLevel();
    public String getCustomerID();
    public String getCustomerName();
    public String getCreatorID();
    public String getCreatorName();
    public int getRating();
    public long getWorkingHours();
    public long getTicketOnHoldHours() ;
    public long getTicketInProgressHours();
    public String getAttachmentID();   
    
    
    public void setTicketID(String ticketID); 
    public void setDescription(String description); 
    public void setStartDate(String startDate);
    public void setExpectedEndDate(String expectedEndDate);
    public void setEndDate(String endDate);
    public void setReporterID(String reporterID);
    public void setEmployeeID(String employeeID);
    public void setAssigneeName(String assigneeName);
    public void setTicketType(String ticketType);
    public void setTicketStatus(String ticketStatus);
    public void setPriority(int priority);
    public void setUrgency(int urgency);
    public void setImpact(int impact);
    public void setTicketLevel(String ticketLevel);    
    public void setCustomeID(String customerID);
    public void setCustomerName(String customerName);
    public void setCreatorID(String creatorID);
    public void setCreatorName(String creatorName);
    public void setRating(int rating);
    public void setWorkingHours(long workingHours);
    public void setTicketOnHoldHours(long ticketOnHoldHours);
    public void setTicketInProgressHours(long ticketInProgressHours);
    public void setAttchmentID(String attachmentID);	
}