package main;

import java.text.ParseException;

import employeeEfficiency.InputEmployeeDetails;
import employeeEfficiency.Interfaces.IEmployeePerformanceDB;
import employeeEfficiency.Interfaces.IInputEmployeeDetails;
import employeeEfficiency.Interfaces.IUserInputEmployeePerformance;
import employeeEfficiency.abstractFactory.EmployeePerformanceFactory;
import employeeEfficiency.abstractFactory.IEmployeePerformanceFactory;
import employeeEfficiency.EmployeePerformanceDB;

public class App 
{
    public static void main( String[] args ) throws ParseException
    {    
    	IUserInputEmployeePerformance u;
    	IEmployeePerformanceFactory performance = EmployeePerformanceFactory.instance();
    	u = performance.userinputemployee();
    	u.userInputEmployeePerformanceDetails();
    } 
}