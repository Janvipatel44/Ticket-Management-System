package customerAnalysis;
import customerAnalysis.Interfaces.*;
import customerAnalysis.abstractfactory.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;
public class ComputeCustomerPropertiesTest
{
    ICustomerAnalysisFactory customerAnalysisFactory;
    CustomerAnalysisFactoryTest customerAnalysisFactoryTest;
    IPersistenceCustomer persistenceCustomer;
    IComputeCustomerProperties computeCustomerProperties;

    @Before
    public void initialize()
    {
        List<IParameterizedCustomerTicket> customerTicketList;
        customerAnalysisFactory = CustomerAnalysisFactory.instance();
        customerAnalysisFactoryTest = new CustomerAnalysisImplementationTest();
        persistenceCustomer = customerAnalysisFactoryTest.getPersistenceCustomerMock();
        customerTicketList = persistenceCustomer.getTicketsOfCustomer("CUST_DAL");
        computeCustomerProperties = customerAnalysisFactory.getComputeCustomerProperties(customerTicketList);
    }

    @Test
    public void getMeanPriorityTest()
    {
        assertEquals("Mean priority failed.", 2.0, computeCustomerProperties.getMeanPriority(), 0.0);
    }

    @Test
    public void getMeanImpactTest()
    {
        assertEquals("Mean impact failed.", 2.0, Math.round(computeCustomerProperties.getMeanImpact()), 0.0);
    }

    @Test
    public void getMeanUrgencyTest()
    {
        assertEquals("Mean urgency failed.", 2.0, computeCustomerProperties.getMeanUrgency(), 0.0);
    }

    @Test
    public void getModeTicketTypeTest()
    {
        assertEquals("Mode ticket type failed.", "Bug", computeCustomerProperties.getModeTicketType());
    }

    @Test
    public void getModeCreatorTest()
    {
        assertEquals("Mode creator failed.", "USER_123", computeCustomerProperties.getModeCreator());
    }

    @Test
    public void getModeTickeLevelTest()
    {
        assertEquals("Mode ticket level failed.", "Easy, Moderate, Hard", computeCustomerProperties.getModeTicketLevel());
    }

    @Test
    public void getAverageResolutionDaysTest()
    {
        assertEquals("Average resolution days failed.", 11.0, Math.round(computeCustomerProperties.getAverageResolutionDays()), 0.0);
    }

    @Test
    public void getCustomerTicketAssigneeStatisticsTest()
    {
        Map<String, Integer> actualResult;
        actualResult = computeCustomerProperties.getCustomerTicketAssigneeStatistics();
        int actual;

        actual = actualResult.get("EMP_123");
        assertEquals("Customer tickets assignee statistics failed.", 1, actual);

        actual = actualResult.get("EMP_124");
        assertEquals("Customer tickets assignee statistics failed.", 1, actual);

        actual = actualResult.get("EMP_125");
        assertEquals("Customer tickets assignee statistics failed.", 1, actual);
    }

    @Test
    public void getMeanRatingTest()
    {
        assertEquals("Mean rating failed.", 3.00, Math.round(computeCustomerProperties.getMeanRating()), 0.0);
    }

}