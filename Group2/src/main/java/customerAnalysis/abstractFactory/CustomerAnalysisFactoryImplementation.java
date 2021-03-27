package customerAnalysis.abstractFactory;
import customerAnalysis.Interfaces.*;
import customerAnalysis.*;
import java.sql.Date;
import java.util.List;
public class CustomerAnalysisFactoryImplementation extends CustomerAnalysisFactory
{
    public IComputeCustomerProperties getComputeCustomerProperties(List<IParameterizedCustomerTicket> tickets)
    {
        return new ComputeCustomerProperties(tickets);
    }

    public ICustomerAnalysis getCustomerAnalysis()
    {
        return new CustomerAnalysis();
    }

    public IParameterizedCustomerTicket getParameterizedCustomerTicket(String ticketID, String customerID, Date startDate, Date endDate, String ticketType, int priority, int urgency, int impact, String ticketLevel, String creatorID, String employeeID, int rating)
    {
        return new ParameterizedCustomerTicket(ticketID, customerID, startDate, endDate, ticketType, priority, urgency, impact, ticketLevel, creatorID, employeeID, rating);
    }

    public IPersistenceCustomer getPersistenceCustomer()
    {
        return new PersistenceCustomer();
    }
}
