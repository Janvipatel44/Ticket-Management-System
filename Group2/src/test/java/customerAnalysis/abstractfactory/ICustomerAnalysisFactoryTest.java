package customerAnalysis.abstractfactory;
import customerAnalysis.Interfaces.*;
public interface ICustomerAnalysisFactoryTest
{
    ICustomerAnalysis getCustomerAnalysis();
    IPersistenceCustomer getPersistenceCustomerMock();
}