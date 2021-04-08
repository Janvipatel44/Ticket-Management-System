package reuseablePackage.interfaces;

public interface ICheckTicketsExists {
	public boolean ticketExists(String ticketID);
	public boolean ticketExistForManager(String ticketID);
	public boolean ticketExistForNotManager(String ticketID,String employeeID);
}
