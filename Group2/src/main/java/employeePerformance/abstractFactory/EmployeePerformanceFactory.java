package employeePerformance.abstractFactory;

import java.sql.ResultSet;
import java.util.ArrayList;

import employeePerformance.BarChartGeneration;
import employeePerformance.EmployeeEfficiencyCalculator;
import employeePerformance.EmployeePerformanceDB;
import employeePerformance.EmployeeProductivityCalculator;
import employeePerformance.FetchedPerformanceDetails;
import employeePerformance.GenerateEmployeePerformanceReport;
import employeePerformance.InputEmployeeDetails;
import employeePerformance.Interfaces.IBarChartGeneration;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.Interfaces.ITableGenerator;
import userinterface.ExportEmployeePerformanceReport;
import userinterface.IExportEmployeePerformanceReport;
import userinterface.IInputOutputHandler;

public class EmployeePerformanceFactory implements IEmployeePerformanceFactory
{ 
	private static IEmployeePerformanceFactory uniqueInstance = null;

    private EmployeePerformanceFactory()
    {
    	
    }

    public static IEmployeePerformanceFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new EmployeePerformanceFactory();
        }
        return uniqueInstance;
    }
    
	public IInputEmployeeDetails userInput(String date, String employeeId) 
	{
		return new InputEmployeeDetails(date, employeeId);
	}
	
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails, IFetchedPerformanceDetails fetchedPerformanceDetails, IInputOutputHandler inputOutputHandler) 
	{	
		return new EmployeePerformanceDB(inputEmployeeDetails, fetchedPerformanceDetails, inputOutputHandler);
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
	
	public IFetchedPerformanceDetails fetchedPerformanceDetails(String ticketLevel, String count, String startDate, String expectedEndDate, String endDate, double workingHours)
	{
		return new FetchedPerformanceDetails(ticketLevel, count, startDate, expectedEndDate, endDate, workingHours);
	}

	public IBarChartGeneration getbarchartGeneration(IInputOutputHandler inputOutputHandler)
	{
		return new BarChartGeneration(inputOutputHandler);

	}

	
}
