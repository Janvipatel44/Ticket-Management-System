package updateTicketDetails.interfaces;

public interface ITicketStatusOperationsDB {

	public double ticketonHoldHours(String ticketID);
    public double ticketInProgressHours(String ticketID);


}
