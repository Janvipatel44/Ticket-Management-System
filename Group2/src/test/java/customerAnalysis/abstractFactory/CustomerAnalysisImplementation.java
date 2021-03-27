package customerAnalysis.abstractFactory;
import customerAnalysis.Interfaces.IPersistenceCustomer;
import customerAnalysis.PersistenceCustomerMock;
public class CustomerAnalysisImplementation
{
    public IPersistenceCustomer getPersistenceCustomerMock()
    {
        return new PersistenceCustomerMock();
    }
}
