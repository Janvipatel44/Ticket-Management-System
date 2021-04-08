package reuseablePackage.interfaces;

public interface ICheckTicketExists {
	public boolean ticketExists(String ticketID);
	public boolean ticketExistForManager(String ticketID);
	public boolean ticketExistForNotManager(String ticketID,String employeeID);
}
