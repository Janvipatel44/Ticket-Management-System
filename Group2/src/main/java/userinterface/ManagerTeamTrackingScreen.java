package userinterface;

import java.util.List;

import Tickets.ICreateTicket;
import login.Interfaces.IParameterizedUser;
import managerfeatures.interfaces.IManagerTeamTracking;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class ManagerTeamTrackingScreen implements IManagerTeamTrackingScreen {

	public final String CHOSE_INVALID_OPTION_MESSAGE = "You chose an invalid option, Please choose an option from the list.";
	public final String UNSUCCESSFUL_DATA_FETCH = "Problem occurred while fetching data from DB. Please contact admin.";
	public final String NO_DATA_AVAILABLE_FOR_TEAM = "Team is not working on any tickets.";

	private IInputOutputHandler inputOutputHandler;
	private IManagerTeamTracking managerTeamTracking;
	IBackToHomePageScreen backToHomePageScreen;
	IUserInterfaceFactory userInterfaceFactory;

	public ManagerTeamTrackingScreen(IInputOutputHandler inputOutputHandler, IManagerTeamTracking managerTeamTracking) {
		this.inputOutputHandler = inputOutputHandler;
		this.managerTeamTracking = managerTeamTracking;
	}

	@Override
	public void displayManagerTrackingScreen(IParameterizedUser user) {

		try {
			String managerId = user.getEmployeeID();
			List<ICreateTicket> teamsTickets = managerTeamTracking.fetchTeamsTicketDetails(managerId);

			if (teamsTickets == null || teamsTickets.size() == 0) {
				inputOutputHandler.displayMethod(NO_DATA_AVAILABLE_FOR_TEAM);
			} else {
				for (ICreateTicket createTicket : teamsTickets) {
					String employeeId = createTicket.getEmployeeId();
					String ticketId = createTicket.getTicketId();
					String description = createTicket.getDescription();
					String employeeTicketDetail = employeeId + "\t" + ticketId + "\t" + description;
					inputOutputHandler.displayMethod(employeeTicketDetail + "\n");
				}
			}
		} catch (Exception e) {
			inputOutputHandler.displayMethod(UNSUCCESSFUL_DATA_FETCH);
		}

		userInterfaceFactory = UserInterfaceFactory.instance();
		backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
		backToHomePageScreen.displayGoBackToHomePageOption(user);
	}
}
