package userinterface;

import java.util.List;

import Tickets.ICreateTicket;
import managerfeatures.interfaces.IManagerTeamTracking;
import menucontroller.MenuHandler;
import menucontroller.abstractfactory.IMenuHandlerFactory;
import menucontroller.abstractfactory.MenuHandlerFactory;
import menucontroller.interfaces.IMenuHandler;

public class ManagerTeamTrackingScreen implements IManagerTeamTrackingScreen {

	public final String CHOSE_INVALID_OPTION_MESSAGE = "You chose an invalid option, Please choose an option from the list.";
	public final String UNSUCCESSFUL_DATA_FETCH = "Problem occurred while fetching data from DB. Please contact admin.";
	public final String NO_DATA_AVAILABLE_FOR_TEAM = "Team is not working on any tickets.";

	private IInputOutputHandler inputOutputHandler;
	private IManagerTeamTracking managerTeamTracking;
	private IMenuHandler menuHandler;

	public ManagerTeamTrackingScreen(IInputOutputHandler inputOutputHandler, IManagerTeamTracking managerTeamTracking) {
		this.inputOutputHandler = inputOutputHandler;
		this.managerTeamTracking = managerTeamTracking;
		IMenuHandlerFactory menuHandlerFactory = MenuHandlerFactory.instance();
		this.menuHandler = menuHandlerFactory.makeMenuHandlerObject();
	}

	@Override
	public void displayManagerTrackingScreen(String managerId, String userType) {

		try {
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

		boolean isUserSelecting = true;

		while (isUserSelecting) {
			try {
				inputOutputHandler.displayMethod("\n\n");
				inputOutputHandler.displayMethod("Press 1 to go back to HomePage ");

				int choice = inputOutputHandler.inputInt();

				if (choice == 1) {
					MenuHandler.Menu menuTaskName = MenuHandler.Menu.HOME_PAGE;
					menuHandler.runMenuTask(menuTaskName, managerId, userType);
				} else {
					inputOutputHandler.displayMethod(CHOSE_INVALID_OPTION_MESSAGE);
				}
			} catch (NumberFormatException e) {
				inputOutputHandler.displayMethod(CHOSE_INVALID_OPTION_MESSAGE);
			}
		}
	}
}
