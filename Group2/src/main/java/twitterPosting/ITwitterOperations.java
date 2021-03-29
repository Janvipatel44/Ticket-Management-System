package twitterPosting;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ITwitterOperations 
{
	public boolean tweetTicket(String description);
	public String generateTweetContent(ResultSet resultSet) throws SQLException; 
}
