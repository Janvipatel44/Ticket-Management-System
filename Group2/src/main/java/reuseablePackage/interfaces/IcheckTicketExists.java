package reuseablePackage.interfaces;

public interface IcheckTicketExists {
	public boolean ticketExists(String ticketID);
	public boolean ticketExistForManager(String ticketID,String employeeID);
	public boolean ticketExistForNotManager(String ticketID,String employeeID);
}
