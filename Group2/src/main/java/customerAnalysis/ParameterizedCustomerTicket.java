package customerAnalysis;
import customerAnalysis.Interfaces.IParameterizedCustomerTicket;

import java.sql.Date;
public class ParameterizedCustomerTicket implements IParameterizedCustomerTicket
{
    private String ticketID;
    private Date startDate;
    private Date endDate;
    private String ticketType;
    private int priority;
    private int urgency;
    private int impact;
    private String ticketLevel;
    private String creatorID;
    private String employeeID;
    private int rating;

    ParameterizedCustomerTicket(String ticketID, Date startDate, Date endDate, String ticketType, int priority, int urgency, int impact, String ticketLevel, String creatorID, String employeeID, int rating)
    {
        this.ticketID = ticketID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.ticketType = ticketType;
        this.priority = priority;
        this.urgency = urgency;
        this.impact = impact;
        this.ticketLevel = ticketLevel;
        this.creatorID = creatorID;
        this.employeeID = employeeID;
        this.rating = rating;
    }

    public String getTicketID()
    {
        return ticketID;
    }

    public Date getStartDate()
    {
        return startDate;
    }

    public Date getEndDate()
    {
        return endDate;
    }

    public String getTicketType()
    {
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

    public String getTicketLevel()
    {
        return ticketLevel;
    }

    public String getCreatorID()
    {
        return creatorID;
    }

    public String getEmployeeID()
    {
        return employeeID;
    }

    public int getRating()
    {
        return rating;
    }
}
