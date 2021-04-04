package twitterPosting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import database.ConnectionManager;
import database.IConnectionManager;
import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import twitterPosting.abstractFactory.IPostHandlingFactory;
import twitterPosting.abstractFactory.PostHandlingFactory;

public class FetchProjectDetailsDB implements IFetchProjectDetailsDB {

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt"; 
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	IPostHandlingFactory posthandling = PostHandlingFactory.instance();
	IInputPostingDetails postDetails;
	ITwitterOperations twitterPost;
	
	public FetchProjectDetailsDB(IInputPostingDetails postDetails)
    {
        this.postDetails = postDetails;
    }
	
	public boolean getticketCountsDB() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success = false;
        boolean hasResult = false;
        ResultSet resultset = null;
        String postDescription = null;
		try {  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call tweetDescriptionGenerator(?)}");
			
			statement.setString(1, postDetails.getTicketId());
            hasResult = statement.execute();
           
            if(hasResult)  
            {  
            	System.out.print("In database");
            	resultset = statement.getResultSet();
            	twitterPost = posthandling.getpostOperations(resultset);
            	postDescription = twitterPost.generateTweetContent();
            	twitterPost.tweetTicket(postDescription); 
            }
			return true;
		} 
		catch (SQLException e) 
		{
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}
	
}