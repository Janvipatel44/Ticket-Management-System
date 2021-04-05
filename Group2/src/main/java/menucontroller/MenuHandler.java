package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuHandler;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;

public class MenuHandler implements IMenuHandler {

	public enum Menu {
		LOGIN, REGISTRATION, FORGOT_PASSWORD, CREATE_TICKET, UPDATE_TICKET, SEARCH_TICKETS, RATING_FEATURE, EMPLOYEE_PERFORMANCE_REPORT, TWITTER_POSTING,
		EMPLOYEE_EFFICENCY, CUSTOMERS_ANALYSIS, OPEN_TICKETS_WITH_TEAM, PERSONAL_MILESTONES, MODIFY_USER_ROLE,
		HOME_PAGE, LOGOUT, EXIT
	}

	@Override
	public void runMenuTask(Menu menuTaskName, IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IMenuTask menuTask = createMenuTaskObject(menuTaskName);
		menuTask.runMenuTask(user, inputOutputHandler);
	}

	private IMenuTask createMenuTaskObject(Menu menuTaskName) {
		IMenuTask menuTask = null;

		switch (menuTaskName) {
		case LOGIN:
			break;
		case REGISTRATION:
			break;
		case FORGOT_PASSWORD:
			break;
		case CREATE_TICKET:
			break;
		case UPDATE_TICKET:
			break;
		case SEARCH_TICKETS:
			break;
		case RATING_FEATURE:
			break;
		case EMPLOYEE_PERFORMANCE_REPORT:
			break;
		case TWITTER_POSTING:
			break;
		case EMPLOYEE_EFFICENCY:
			break;
		case CUSTOMERS_ANALYSIS:
			break;
		case OPEN_TICKETS_WITH_TEAM:
			break;
		case PERSONAL_MILESTONES:
			break;
		case MODIFY_USER_ROLE:
			break;
		case HOME_PAGE:
			break;
		case LOGOUT:
			break;
		case EXIT:
			break;
		}
		
		return menuTask;
	}

}
