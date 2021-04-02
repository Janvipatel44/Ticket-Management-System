package menucontroller;

public class MenuHandler {

	private final String CREATE_TICKET = "Create ticket";
	private final String EMPLOYEE_EFFICIENT_REPORT = "Employee efficient report";
	private final String SEARCH_TICKETS = "Search tickets";
	private final String UPDATE_TICKET = "Update ticket";
	private final String RATING_FEATURE = "Rating feature";
	private final String CUSTOMERS_HEALTH = "Check customers health";
	private final String OPEN_TICKETS_WITH_TEAM = "Open tickets with team";
	private final String PERSONAL_MILESTONES = "Personal Milestones";

	public void runMenuTask(String menuTaskName, String empId) {
		IMenuTask menuTask = createMenuTaskObject(menuTaskName);
		menuTask.runMenuTask();
	}

	private IMenuTask createMenuTaskObject(String menuTaskName) {
		IMenuTask menuTask = null;

		switch (menuTaskName) {
		case CREATE_TICKET:
			break;
		case EMPLOYEE_EFFICIENT_REPORT:
			break;
		case SEARCH_TICKETS:
			break;
		case UPDATE_TICKET:
			break;
		case RATING_FEATURE:
			break;
		case CUSTOMERS_HEALTH:
			break;
		case OPEN_TICKETS_WITH_TEAM:
			break;
		case PERSONAL_MILESTONES:
			break;
		}

		return menuTask;
	}

}
