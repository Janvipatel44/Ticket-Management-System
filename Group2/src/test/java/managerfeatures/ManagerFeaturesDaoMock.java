package managerfeatures;

import java.util.ArrayList;
import java.util.List;
import Tickets.CreateTicket;
import Tickets.ICreateTicket;
import managerfeatures.interfaces.IManagerFeaturesDao;
import validations.StringValidations;

public class ManagerFeaturesDaoMock implements IManagerFeaturesDao {

	private final String MANAGER_ID = "M101";
	private final String EMPLOYEE_ID = "E101";
	private final String TICKET_ID = "TICKET1";
	private final String DESCRIPTION = "Facing issues fetching data from DB";

	@Override
	public List<ICreateTicket> managersTeamTickets(String managerId) throws Exception {
		List<ICreateTicket> createTickets = null;
		if (StringValidations.isStringValid(managerId) && managerId.trim().equalsIgnoreCase(MANAGER_ID)) {
			createTickets = new ArrayList<ICreateTicket>();
			ICreateTicket createTicket = new CreateTicket();
			createTicket.setEmployeeId(EMPLOYEE_ID);
			createTicket.setTicketId(TICKET_ID);
			createTicket.setDescription(DESCRIPTION);
			createTickets.add(createTicket);
		}
		return null;
	}

}
