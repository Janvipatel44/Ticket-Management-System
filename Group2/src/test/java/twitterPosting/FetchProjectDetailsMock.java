package twitterPosting;

public class FetchProjectDetailsMock
{	
	public boolean getticketCountsDB(String ticketId)
	{
		if(ticketId == "111") 
		{
			return true;
		}
		else if (ticketId == "1555")
		{
			return false;
		}
		return false;
	}
}
