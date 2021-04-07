package menucontroller;

import login.Interfaces.IParameterizedUser;
import menucontroller.interfaces.IMenuTask;
import userinterface.IInputOutputHandler;
import userinterface.IcommentOnTicketScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class CommentOnTicketMenuTask implements IMenuTask
{

	@Override
	public void runMenuTask(IParameterizedUser user, IInputOutputHandler inputOutputHandler) {
		IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
		IcommentOnTicketScreen commentonticketscreen = userInterfaceFactory.getCommentOnTicketScreen(inputOutputHandler);
		commentonticketscreen.commentonticketscreen(user);	
	}

}
