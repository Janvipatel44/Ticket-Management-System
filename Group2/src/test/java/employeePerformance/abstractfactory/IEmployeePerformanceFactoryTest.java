package employeePerformance.abstractfactory;

import java.sql.ResultSet;
import employeePerformance.Interfaces.IEmployeeEfficiencyCalculator;
import employeePerformance.Interfaces.IEmployeeProductivityCalculator;

public interface IEmployeePerformanceFactoryTest 
{
	  public IEmployeeEfficiencyCalculator getEmployeeEfficiency(ResultSet resultSet);
	  public IEmployeeProductivityCalculator getEmployeePerformance(ResultSet resultSet);
}
