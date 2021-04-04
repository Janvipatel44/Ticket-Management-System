package comments;

import java.sql.Date;
import java.text.SimpleDateFormat;

import commentOnTicket.interfaces.IcommentOnTicket;

public class commentOnTicketMock implements IcommentOnTicket 
{
	private SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd");
	private Date date = new Date(System.currentTimeMillis());
	
	
	public boolean postCommentOnticket(String ticketId, String UserName, String comment) {
		String dateInfo = formatter.format(date);
		System.out.println(ticketId + UserName + comment + dateInfo);
		return true;
	}

}
