package employeePerformanceReport;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.junit.Test;

import employeePerformance.FetchedPerformanceDetails;
import employeePerformance.GenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IBarChartGeneration;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.abstractfactory.EmployeePerformanceFactoryTest;
import employeePerformance.abstractfactory.IEmployeePerformanceFactoryTest;
import userinterface.IInputOutputHandler;
import userinterface.abstractFactory.IUserInterfaceFactory;
import userinterface.abstractFactory.UserInterfaceFactory;

public class EmployeeEfficiencyReportTest {

	IEmployeePerformanceFactoryTest employeePerformanceTest =  EmployeePerformanceFactoryTest.instance();
	IUserInterfaceFactory userInterfaceFactoryTest = UserInterfaceFactory.instance();
	IInputOutputHandler inputOutputHandler = userInterfaceFactoryTest.getInputOutputHandler();
	IGenerateEmployeePerformanceReport generateReport = employeePerformanceTest.getPerformanceReport(inputOutputHandler);
	IInputEmployeeDetails employeeDetails;	
	IFetchedPerformanceDetails fetchedPerformanceDetails;

			
	@Test
	public void test() 
	{
		employeeDetails =  employeePerformanceTest.userInput("2020-04-02","emp123");
		//ArrayList<FetchedPerformanceDetails> list = new ArrayList<FetchedPerformanceDetails>();
		
		/*list.add(employeePerformanceTest.fetchedPerformanceDetails("easy", "1", null, null, null, 0));
		employeePerformanceTest.fetchedPerformanceDetails("hard", "2", null, null, null, 0);
		employeePerformanceTest.fetchedPerformanceDetails("medium", "4", null, null, null, 0);

		System.out.print(displayEmployeeDetailsAndTicketCount(employeeDetails,list));*/
		
	}

}
