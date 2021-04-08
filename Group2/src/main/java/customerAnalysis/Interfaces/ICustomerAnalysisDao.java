package customerAnalysis.Interfaces;
import java.util.List;
public interface ICustomerAnalysisDao
{
    List<IParameterizedCustomerTicket> getTicketsOfCustomer(String customerID);
}
