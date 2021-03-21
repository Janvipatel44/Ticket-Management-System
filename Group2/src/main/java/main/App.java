package main;

import java.text.ParseException;

import Tickets.IInsertTicket;
import Tickets.InsertTicket;
import employeeEfficiency.IInputEmployeeDetails;
import employeeEfficiency.InputEmployeeDetails;
import employeeEfficiency.EmployeeDetailsDB;
import employeeEfficiency.IEmployeeDetailsDB;

public class App 
{
    public static void main( String[] args ) throws ParseException
    {
    	IInputEmployeeDetails employeeDetails = new InputEmployeeDetails();
    	IInsertTicket insertTickets = new InsertTicket();
    	
    	insertTickets.userInputTicketDetails();
    	employeeDetails.setDate("2020-01-01");
    	employeeDetails.setEmployeeId("EMP123");
    	
    	IEmployeeDetailsDB employeedetailsDB = new EmployeeDetailsDB(employeeDetails);
    	employeedetailsDB.ticketCounts();
    	employeedetailsDB.employee_Efficiency();
    } 
}