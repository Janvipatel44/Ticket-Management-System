package customerAnalysis.abstractfactory;
import customerAnalysis.CustomerAnalysisFacade;
import customerAnalysis.Interfaces.ICustomerAnalysis;
import customerAnalysis.Interfaces.IPersistenceCustomer;
import customerAnalysis.PersistenceCustomerMock;
public class CustomerAnalysisFactoryTest implements ICustomerAnalysisFactoryTest
{
    private static ICustomerAnalysisFactoryTest uniqueInstance = null;

    private CustomerAnalysisFactoryTest()
    {

    }

    public static ICustomerAnalysisFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new CustomerAnalysisFactoryTest();
        }
        return uniqueInstance;
    }

    public ICustomerAnalysis getCustomerAnalysis()
    {
        IPersistenceCustomer persistenceCustomerMock = getPersistenceCustomerMock();
        return new CustomerAnalysisFacade(persistenceCustomerMock);
    }

    public IPersistenceCustomer getPersistenceCustomerMock()
    {
        return new PersistenceCustomerMock();
    }
}
