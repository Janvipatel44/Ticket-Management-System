package customerAnalysis.abstractFactory;
import customerAnalysis.Interfaces.IPersistenceCustomer;
import customerAnalysis.PersistenceCustomerMock;
public class CustomerAnalysisImplementationTest extends CustomerAnalysisFactoryTest
{
    public IPersistenceCustomer getPersistenceCustomerMock()
    {
        return new PersistenceCustomerMock();
    }
}
