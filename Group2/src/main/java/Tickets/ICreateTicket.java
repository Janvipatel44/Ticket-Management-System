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
    public String getComments(); 
    
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
    public void setComments(String comments);
}
