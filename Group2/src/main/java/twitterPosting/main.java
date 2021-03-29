package twitterPosting;

import java.text.ParseException;

public class main {
	
	public static void main( String[] args ) throws ParseException 
    {
    	IInputPostingDetails post = new InputPostingDetails();
    	post.setTicketId("123");
    	IFetchProjectDetailsDB fetch = new FetchProjectDetailsDB(post);

    	fetch.getticketCountsDB();
    
    } 
	
}
