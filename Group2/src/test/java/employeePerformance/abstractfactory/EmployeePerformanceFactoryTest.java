package employeePerformance.abstractfactory;

import employeePerformance.EmployeeEfficiencyCalculator;
import employeePerformance.EmployeeProductivityCalculator;
import employeePerformance.FetchedPerformanceDetails;
import employeePerformance.GenerateEmployeePerformanceReport;
import employeePerformance.InputEmployeeDetails;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformanceReport.EmployeePerformanceDBMock;
import userinterface.IInputOutputHandler;

public class EmployeePerformanceFactoryTest implements IEmployeePerformanceFactoryTest
{ 
	private static IEmployeePerformanceFactoryTest uniqueInstance = null;
	
    private EmployeePerformanceFactoryTest()
    {
    	
    }

    public static IEmployeePerformanceFactoryTest instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new EmployeePerformanceFactoryTest();
        }
        return uniqueInstance;
    }
    
	
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails, IFetchedPerformanceDetails fetchedPerformanceDetails, IInputOutputHandler inputOutputHandler) 
	{	
		return new EmployeePerformanceDBMock(inputEmployeeDetails, fetchedPerformanceDetails, inputOutputHandler);
	}

	public IGenerateEmployeePerformanceReport getPerformanceReport (IInputOutputHandler inputOutputHandler) 
	{	
		return new GenerateEmployeePerformanceReport(inputOutputHandler);
	}
	
	public IEmployeeEfficiencyCalculator getEmployeeEfficiencyCalculator(IInputOutputHandler inputOutputHandler) 
	{
		return new EmployeeEfficiencyCalculator(inputOutputHandler);
	}
	
	public IEmployeeProductivityCalculator getEmployeeProductivityCalculator(IInputOutputHandler inputOutputHandler)
	{
		return new EmployeeProductivityCalculator(inputOutputHandler);
	}
	
	public IInputEmployeeDetails userInput(String date, String employeeId)
	{
		return new InputEmployeeDetails(date,employeeId);

	}
	
	public IFetchedPerformanceDetails fetchedPerformanceDetails(String ticketLevel, String count, String startDate, String expectedEndDate, String endDate, double workingHours)
	{
		return new FetchedPerformanceDetails(ticketLevel, count, startDate, expectedEndDate, endDate, workingHours);
	}
	
}
