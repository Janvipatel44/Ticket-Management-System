package Tickets;

public class CreateTicket implements ICreateTicket
{
	private String ticketId = null;
    private String description = null;
    private String startDate = null;
    private String endDate = null;
    private String reporterId = null;
    private String employeeId = null;
    private String assigneeName = null;
    private String ticketType = null;
    private int priority = 0;
    private int urgency = 0;
    private int impact = 0;
    private String comments = null;

   
    public String getTicketId() {
        return ticketId;
    }

    public String getDescription() {
        return description;
    }
    
    public String getStartDate() {
        return startDate;
    }
    
    public String getEndDate() {
        return endDate;
    }
    
    public String getReporterId() {
        return reporterId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getAssigneeName() {
        return assigneeName;
    }
    
    public String getTicketType() {
        return ticketType;
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
    
    public String getComments() {
    	return comments;
    }
 
    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setDescription(String description) {
        this.description= description;
    }
    
    public void setStartDate(String startDate)
    {
        this.startDate= startDate;
    }
    
    public void setEndDate(String endDate) 
    {
        this.endDate = endDate;
    }
    
    public void setReporterId(String reporterId) 
    {
        this.reporterId = reporterId;
    }

    public void setEmployeeId(String employeeId) 
    {
        this.employeeId = employeeId;
    }

    public void setAssigneeName(String assigneeName) 
    {
        this.assigneeName = assigneeName;
    }
    
    public void setTicketType(String ticketType) 
    {
        this.ticketType = ticketType;
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
    
    public void setComments(String comments) 
    {
    	this.comments = comments;
    }
}
