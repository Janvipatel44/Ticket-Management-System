package employeePerformanceReport;

import java.text.ParseException;
import java.util.ArrayList;

import employeePerformance.Interfaces.IEmployeePerformanceDB;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import userinterface.IInputOutputHandler;

public class EmployeePerformanceDBMock implements IEmployeePerformanceDB
{
		IInputEmployeeDetails inputEmployeeDetails;
		IInputOutputHandler inputOutputHandler;
		IFetchedPerformanceDetails fetchedPerformanceDetails;
		 
		public EmployeePerformanceDBMock(IInputEmployeeDetails inputEmployeeDetails, 
			IFetchedPerformanceDetails fetchedPerformanceDetails, IInputOutputHandler inputOutputHandler) {
			this.inputEmployeeDetails = inputEmployeeDetails;
			this.fetchedPerformanceDetails = fetchedPerformanceDetails;
			this.inputOutputHandler = inputOutputHandler;
		}

		public EmployeePerformanceDBMock(IInputEmployeeDetails employeeDetails)
	    {
	        this.inputEmployeeDetails = employeeDetails;
	    }


		@Override
		public ArrayList<String> getticketCountsDB() throws ParseException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<String> getemployeeEfficiencyDB() throws ParseException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ArrayList<String> getemployeeProductivityDB() throws ParseException {
			// TODO Auto-generated method stub
			return null;
		}
}

