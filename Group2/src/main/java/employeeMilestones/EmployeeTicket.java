package employeeMilestones;
import java.sql.Date;
public class EmployeeTicket implements IEmployeeTicket
{
    private String ticketID;
    private String employeeID;
    private String customerID;
    private Date startDate;
    private Date endDate;
    private int rating;

    EmployeeTicket(String ticketID, String employeeID, String customerID, Date startDate, Date endDate, int rating)
    {
        this.ticketID = ticketID;
        this.employeeID = employeeID;
        this.customerID = customerID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
    }

    String getTicketID()
    {
        return ticketID;
    }

    String getEmployeeID()
    {
        return  employeeID;
    }

    String getCustomerID()
    {
        return customerID;
    }

    Date getStartDate()
    {
        return startDate;
    }

    Date getEndDate()
    {
        return endDate;
    }

    int getRating()
    {
        return rating;
    }
}
