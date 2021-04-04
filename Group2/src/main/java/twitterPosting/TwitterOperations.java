package twitterPosting;
import java.sql.ResultSet;
import java.sql.SQLException;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;
import twitterPosting.Interfaces.ITwitterOperations;

public class TwitterOperations implements ITwitterOperations {

		static String consumerKeyStr = "P1h3b6FpRWRXcZ6CR4NRFC1Ve";
		static String consumerSecretStr = "mxmHZiASD0NjX7iMQaHAsxBj9HXEPX9TB8FUlka3URCFQCfLKB";
		static String accessTokenStr = "1363841955441090562-Br3xfe5mKLTWqF1cqq1K2CIfHv4yKc";
		static String accessTokenSecretStr = "LuMAwH640LFId3mZCFLNbPhcjBubCoimzw3CJSTy2S5Fp";

		ResultSet resultSet;
		public TwitterOperations(ResultSet resultSet){
			this.resultSet = resultSet;
		}
		public String generateTweetContent() throws SQLException 
		{
			String description = null;
			String workingHours = null;
			String startDate = null;
			String endDate = null;
			String ticketType = null;
			String firstName = null;
			String lastName = null;
	    	String postDescription = null;

			while(resultSet.next()) {
    		System.out.println("\nDescription:" +resultSet.getString("description"));
    		System.out.println("\nWorking Hours:" +resultSet.getString("resolutionHours"));
    		System.out.println("\nStart Date:" +resultSet.getString("startDate"));
    		System.out.println("\nEnd Date:" +resultSet.getString("endDate"));
    		System.out.println("\nTicket Type:" +resultSet.getString("ticketType"));
    		System.out.println("\nManager FirstName:" +resultSet.getString("firstName"));
    		System.out.println("\nManager LastName:" +resultSet.getString("lastName"));
    		
    		description = resultSet.getString("description");
    		workingHours = resultSet.getString("resolutionHours");
    		startDate = resultSet.getString("startDate");
    		endDate = resultSet.getString("endDate");
    		ticketType = resultSet.getString("ticketType");
    		firstName = resultSet.getString("firstName");
    		lastName = resultSet.getString("lastName");
			}
    		
    		postDescription = "Happy to announce that I have been working on a " +ticketType + " named: '" + description + "' for  " + workingHours +
    					" since " + startDate + endDate + " with the guidance of my manager " + firstName + lastName;
    		
	    	
			return postDescription;
		}

		public boolean tweetTicket(String postDescription) 
		{
			try 
			{
				Twitter twitter = new TwitterFactory().getInstance();

				twitter.setOAuthConsumer(consumerKeyStr, consumerSecretStr);
				AccessToken accessToken = new AccessToken(accessTokenStr,
						accessTokenSecretStr);

				twitter.setOAuthAccessToken(accessToken);

				twitter.updateStatus(postDescription);

				System.out.println("Successfully updated the status in Twitter.");
				return true;

			} 
			catch (TwitterException te)
			{
				te.printStackTrace();
				return false;
			}
		
		}
}

