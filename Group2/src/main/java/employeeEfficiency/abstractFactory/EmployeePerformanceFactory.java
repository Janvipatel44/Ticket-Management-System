package employeeEfficiency.abstractFactory;

import java.sql.ResultSet;

import employeeEfficiency.EmployeeEfficiencyCalculator;
import employeeEfficiency.EmployeePerformanceDB;
import employeeEfficiency.EmployeeProductivityCalculator;
import employeeEfficiency.GenerateEmployeePerformanceReport;
import employeeEfficiency.InputEmployeeDetails;
import employeeEfficiency.UserInputEmployeePerformance;
import employeeEfficiency.Interfaces.IEmployeeEfficiencyCalculator;
import employeeEfficiency.Interfaces.IEmployeePerformanceDB;
import employeeEfficiency.Interfaces.IEmployeeProductivityCalculator;
import employeeEfficiency.Interfaces.IGenerateEmployeePerformanceReport;
import employeeEfficiency.Interfaces.IInputEmployeeDetails;
import employeeEfficiency.Interfaces.IUserInputEmployeePerformance;

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
	
	public IEmployeePerformanceDB employeedetailsDB ( IInputEmployeeDetails inputEmployeeDetails ) 
	{	
		return new EmployeePerformanceDB(inputEmployeeDetails);
	}

	public IGenerateEmployeePerformanceReport getPerformanceReport (IInputEmployeeDetails inputEmployeeDetails) 
	{	
		return new GenerateEmployeePerformanceReport(inputEmployeeDetails);
	}
	
	public IEmployeeEfficiencyCalculator getEmployeeEfficiencyCalculator(ResultSet resultset) 
	{
		return new EmployeeEfficiencyCalculator(resultset);
	}
	
	public IEmployeeProductivityCalculator getEmployeeProductivityCalculator(ResultSet resultset)
	{
		return new EmployeeProductivityCalculator(resultset);
	}
	
	public IUserInputEmployeePerformance userinputemployee()
	{
		return new UserInputEmployeePerformance();
	}
}
