package managerfeatures.interfaces;

import java.util.List;
import Tickets.ICreateTicket;

public interface IManagerFeaturesDao {
	
	public List<ICreateTicket> managersTeamTickets(String managerId) throws Exception;

}
