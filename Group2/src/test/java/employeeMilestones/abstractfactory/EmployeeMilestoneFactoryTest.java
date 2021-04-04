package employeeMilestones.abstractfactory;
import employeeMilestones.EmployeeMilestoneFacade;
import employeeMilestones.PersistenceEmployeeTicketsMock;
import employeeMilestones.interfaces.*;
public class EmployeeMilestoneFactoryTest implements IEmployeeMilestoneFactoryTest
{
    private static IEmployeeMilestoneFactoryTest uniqueInstance = null;

    private EmployeeMilestoneFactoryTest()
    {

    }

    public static IEmployeeMilestoneFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new EmployeeMilestoneFactoryTest();
        }
        return uniqueInstance;
    }

    public IPersistenceEmployeeTickets getPersistenceEmployeeTicketsMock()
    {
        return new PersistenceEmployeeTicketsMock();
    }

    public IEmployeeMilestone getEmployeeMilestone()
    {
        IPersistenceEmployeeTickets persistenceEmployeeTicketsMock = getPersistenceEmployeeTicketsMock();
        return new EmployeeMilestoneFacade(persistenceEmployeeTicketsMock);
    }
}

