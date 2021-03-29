package twitterPosting;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;

import database.ConnectionManager;
import database.IConnectionManager;

public class FetchProjectDetailsDB implements IFetchProjectDetailsDB {

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt"; 
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);

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
            	resultset = statement.getResultSet();
            	twitterPost = new TwitterOperations();
            	postDescription = twitterPost.generateTweetContent(resultset);
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