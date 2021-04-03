package managerfeatures.interfaces;

import java.util.List;

import Tickets.ICreateTicket;

public interface IManagerTeamTracking {
	
	public List<ICreateTicket> fetchTeamsTicketDetails(String managerId) throws Exception;
	
}
