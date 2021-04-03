package customerAnalysis.abstractFactory;
import customerAnalysis.Interfaces.*;
import java.sql.Date;
import java.util.List;
public abstract class CustomerAnalysisFactory
{
    public abstract IComputeCustomerProperties getComputeCustomerProperties(List<IParameterizedCustomerTicket> tickets);
    public abstract ICustomerAnalysis getCustomerAnalysis();
    public abstract IParameterizedCustomerTicket getParameterizedCustomerTicket(String ticketID, String customerID, Date startDate, Date endDate, String ticketType, int priority, int urgency, int impact, String ticketLevel, String creatorID, String employeeID, int rating);
    public abstract IPersistenceCustomer getPersistenceCustomer();
}
