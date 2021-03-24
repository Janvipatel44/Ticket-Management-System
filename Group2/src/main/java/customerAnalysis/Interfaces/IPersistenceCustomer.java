package customerAnalysis.Interfaces;
import java.util.List;
public interface IPersistenceCustomer
{
    List getTicketsOfCustomer(String customerID);
}
