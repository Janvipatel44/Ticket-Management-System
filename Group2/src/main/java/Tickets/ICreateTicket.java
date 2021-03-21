package Tickets;

public interface ICreateTicket {
    
	public String getTicketId();
    public String getDescription(); 
    public String getStartDate(); 
    public String getEndDate(); 
    public String getReporterId(); 
    public String getEmployeeId(); 
    public String getAssigneeName(); 
    public String getTicketType(); 
    public int getPriority();
    public int getUrgency(); 
    public int getImpact();
    public String getTicketLevel(); 
	public String getCreatorName();
	public String getAttachmentID();
	public int getRating();
	public String getCustomerName();
	
	
    public void setTicketId(String ticketId);
    public void setDescription(String description);
    public void setStartDate(String startDate);
    public void setEndDate(String endDate);
    public void setReporterId(String reporterId);
    public void setEmployeeId(String employeeId);
    public void setAssigneeName(String assigneeName);
    public void setTicketType(String ticketType);
    public void setPriority(int priority);
    public void setUrgency(int urgency);
    public void setImpact(int impact);  
	public void setTicketLevel(String ticketLevel);
	public void setCustomerName(String customerName);
	public void setRating(int rating);
	public void setCreatorName(String creatorName);
	public void setAttchmentID(String attachmentID);
}
