package twitterPosting;

import java.text.ParseException;

import userinterface.IInputOutputHandler;
import userinterface.ITwitterPostScreen;
import userinterface.InputOutputHandler;
import userinterface.TwitterPostScreen;

public class main {
	
	public static void main( String[] args ) throws ParseException 
    {
		/*IPostHandlingFactory posthandling = PostHandlingFactory.instance();
		IUserInputTwitterPost userinput;
		userinput = posthandling.userinput();
		userinput.getticketCountsDB();*/
		IInputOutputHandler input = new InputOutputHandler();
		ITwitterPostScreen posthandling = new TwitterPostScreen(input);
		//posthandling.displayTwitterPostScreen();
    } 
	
}
