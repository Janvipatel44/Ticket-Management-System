package twitterPosting;

import java.text.ParseException;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.IUserInputTwitterPost;
import twitterPosting.abstractFactory.IPostHandlingFactory;
import twitterPosting.abstractFactory.PostHandlingFactory;

public class main {
	
	public static void main( String[] args ) throws ParseException 
    {
		IPostHandlingFactory posthandling = PostHandlingFactory.instance();
		IUserInputTwitterPost userinput;
		userinput = posthandling.userinput();
		userinput.getticketCountsDB();
    } 
	
}
