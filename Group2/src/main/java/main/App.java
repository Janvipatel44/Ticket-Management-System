package main;

import java.text.ParseException;

import employeeEfficiency.IInputEmployeeDetails;
import employeeEfficiency.InputEmployeeDetails;
import employeeEfficiency.EmployeePerformanceDB;
import employeeEfficiency.IEmployeePerformanceDB;

public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	IInputEmployeeDetails employeeDetails = new InputEmployeeDetails();
    	
    	employeeDetails.setDate("2020-01-01");
    	employeeDetails.setEmployeeId("EMP123");
    	
    	IEmployeePerformanceDB employeedetailsDB = new EmployeePerformanceDB(employeeDetails);
    	employeedetailsDB.getticketCountsDB(); 
    	employeedetailsDB.getemployeeEfficiencyDB();
    	employeedetailsDB.getemployeeProductivityDB();
    } 
}