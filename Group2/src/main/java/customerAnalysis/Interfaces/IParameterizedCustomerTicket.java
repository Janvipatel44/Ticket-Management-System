package customerAnalysis.Interfaces;
import java.sql.Date;
public interface IParameterizedCustomerTicket
{
    String getTicketID();
    Date getStartDate();
    Date getEndDate();
    String getTicketType();
    int getPriority();
    int getUrgency();
    int getImpact();
    String getTicketLevel();
    String getCreatorID();
    String getEmployeeID();
    int getRating();
}
