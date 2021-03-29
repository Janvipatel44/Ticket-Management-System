package twitterPosting;

public class InputPostingDetails implements IInputPostingDetails
{
    private String ticketId = null;

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId= ticketId;
    }
}
