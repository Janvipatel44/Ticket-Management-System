package customerAnalysis.abstractfactory;
import customerAnalysis.Interfaces.*;

import java.io.IOException;
import java.sql.Date;
import java.util.List;
public interface ICustomerAnalysisFactory
{
    IComputeCustomerProperties getComputeCustomerProperties(List<IParameterizedCustomerTicket> tickets);
    ICustomerAnalysis getCustomerAnalysis() throws IOException;
    IParameterizedCustomerTicket getParameterizedCustomerTicket(String ticketID, String customerID, Date startDate, Date endDate, String ticketType, int priority, int urgency, int impact, String ticketLevel, String creatorID, String employeeID, int rating);
    ICustomerAnalysisDao getPersistenceCustomer() throws IOException;
}
