package twitterPosting;

import java.text.ParseException;
import java.util.Scanner;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.IUserInputTwitterPost;
import twitterPosting.abstractFactory.IPostHandlingFactory;
import twitterPosting.abstractFactory.PostHandlingFactory;

public class UserInputTwitterPost implements IUserInputTwitterPost{

	public boolean getticketCountsDB() throws ParseException
	{
	
		IPostHandlingFactory posthandling = PostHandlingFactory.instance();
		IFetchProjectDetailsDB fetchticket;
		IInputPostingDetails inputposting;
		Scanner sc = new Scanner(System.in);
		String ticketID = null;
	  
		System.out.println("Please enter ticket Id:");
		ticketID = sc.nextLine();

		inputposting = posthandling.inputposting(ticketID);
		
		fetchticket = posthandling.fetchticket(inputposting);
		fetchticket.getticketCountsDB();
		return true;
	}
}
