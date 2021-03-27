package customerAnalysis;
import customerAnalysis.Interfaces.IComputeCustomerProperties;
import customerAnalysis.Interfaces.IParameterizedCustomerTicket;
import customerAnalysis.Interfaces.IPersistenceCustomer;
import customerAnalysis.abstractFactory.CustomerAnalysisFactory;
import customerAnalysis.abstractFactory.CustomerAnalysisFactoryImplementation;
import org.junit.Before;

import java.util.List;

import static org.junit.Assert.*;
public class ComputeCustomerPropertiesTest
{
    CustomerAnalysisFactory customerAnalysisFactory;
    IPersistenceCustomer persistenceCustomer;
    IComputeCustomerProperties computeCustomerProperties;

    @Before
    public void initialize()
    {
        List<IParameterizedCustomerTicket> customerTicketList;
        customerAnalysisFactory = new CustomerAnalysisFactoryImplementation();
        persistenceCustomer = customerAnalysisFactory.getPersistenceCustomer();
        customerTicketList = persistenceCustomer.
        computeCustomerProperties = customerAnalysisFactory.getComputeCustomerProperties()
    }
}