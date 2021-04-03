package interfacs;

public interface IcheckTicketExists {
	public boolean ticketExistsForCreator(String ticketID, String employeeID);
	public boolean ticketExistsForAssignee(String ticketID, String employeeID);
}
