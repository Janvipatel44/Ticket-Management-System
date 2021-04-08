package employeePerformance.abstractfactory;

import java.sql.ResultSet;
import employeePerformance.EmployeeEfficiencyCalculator;
import employeePerformance.EmployeeProductivityCalculator;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;

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

	    public IEmployeeEfficiencyCalculator getEmployeeEfficiency(ResultSet resultSet)
	    {
	        return new EmployeeEfficiencyCalculator(resultSet);
	    }

	    public IEmployeeProductivityCalculator getEmployeePerformance(ResultSet resultSet)
	    {
	        return new EmployeeProductivityCalculator(resultSet);
	    }
}
