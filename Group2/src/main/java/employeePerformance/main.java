package employeePerformance;

import login.Interfaces.IParameterizedUser;
import userinterface.IEmployeePerformanceScreen;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class main
{
	
		public static void main(String [] args)
		{
			IUserInterfaceFactory userInterfaceFactory = UserInterfaceFactory.instance();
			IEmployeePerformanceScreen employeePerformanceScreen = userInterfaceFactory.getEmployeePerformanceScreen(null);
			employeePerformanceScreen.displayTicketGenerationScreen(null);
		
		}
}
