package twitterPosting;

import static org.junit.Assert.*;

import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;
import twitterPosting.Interfaces.ITwitterOperations;
import twitterPosting.abstractfactory.ITwitterPostingTest;
import twitterPosting.abstractfactory.TwitterPostingTest;
import userinterface.IInputOutputHandler;

public class TwitterOperationsTest
{
	 	ITwitterPostingTest postHandlingFactoryTest = TwitterPostingTest.instance();
	    ITwitterOperations twitterOperations;
	    IInputOutputHandler inputOutputHandler;
	    TwitterOperationsMock twitterOperationsMock;
	    @Before
	    public void initialize()
	    {
			twitterOperations = postHandlingFactoryTest.getpostOperations(null,inputOutputHandler);
	    }
 
	    @Test
	    public void checkPosting() 
	    {
			String postDescription= "Glad  to announce that I have been working on a ticketType - feature for 20 workingHours with the guidance of manage";
	    	assertTrue(twitterOperations.tweetTicket(postDescription));
	    }
}