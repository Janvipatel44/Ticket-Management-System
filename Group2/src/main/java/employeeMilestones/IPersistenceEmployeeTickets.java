package employeeMilestones;
import java.util.List;
public interface IPersistenceEmployeeTickets
{
    List<IEmployeeTicket> getEmployeeTickets(String employeeID);
}
