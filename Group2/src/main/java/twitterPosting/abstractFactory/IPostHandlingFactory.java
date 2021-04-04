package twitterPosting.abstractFactory;

import java.sql.ResultSet;

import twitterPosting.Interfaces.IFetchProjectDetailsDB;
import twitterPosting.Interfaces.IInputPostingDetails;
import twitterPosting.Interfaces.ITwitterOperations;
import twitterPosting.Interfaces.IUserInputTwitterPost;

public interface IPostHandlingFactory {

	public ITwitterOperations getpostOperations(ResultSet resultset);
	public IInputPostingDetails inputposting(String ticketId);
	public IFetchProjectDetailsDB fetchticket( IInputPostingDetails inputposting);
	public IUserInputTwitterPost userinput();

}
