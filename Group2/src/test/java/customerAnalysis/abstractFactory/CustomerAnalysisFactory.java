package customerAnalysis.abstractFactory;
import customerAnalysis.Interfaces.IPersistenceCustomer;
public abstract class CustomerAnalysisFactory
{
    public abstract IPersistenceCustomer getPersistenceCustomerMock();
}
