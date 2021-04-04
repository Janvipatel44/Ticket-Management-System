package employeeMilestones.interfaces;
import java.util.List;
public interface IPersistenceEmployeeTickets
{
    List<IParameterizedEmployeeTicket> getEmployeeTickets(String employeeID);
}
