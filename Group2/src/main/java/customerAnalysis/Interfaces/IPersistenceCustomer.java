package customerAnalysis.Interfaces;
import java.util.List;
public interface IPersistenceCustomer
{
    List<IParameterizedCustomerTicket> getTicketsOfCustomer(String customerID);
}
