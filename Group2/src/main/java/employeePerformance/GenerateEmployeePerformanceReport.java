package employeePerformance;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import employeePerformance.Interfaces.IBarChartGeneration;
import employeePerformance.Interfaces.IExportEmployeePerformanceReport;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.Interfaces.ITableGenerator;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import userinterface.IInputOutputHandler;

public class GenerateEmployeePerformanceReport implements IGenerateEmployeePerformanceReport
{	
		private ArrayList<String> employeeDetailsString = new ArrayList<String>();
		private IInputEmployeeDetails employeeDetails = null;
		private IExportEmployeePerformanceReport employeePerformanceReport ;
		private IBarChartGeneration barchart;
		private IInputOutputHandler inputOutputHandler;
	    private IEmployeePerformanceFactory employeePerformanceFactory = EmployeePerformanceFactory.instance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		
		public ArrayList<String> displayEmployeeDetailsAndTicketCount( IInputEmployeeDetails employeeDetails, ResultSet resultset) throws SQLException, ParseException
		{
			TableGenerator tableEmployeeInformation = new TableGenerator();
	        List<String> headersList = new ArrayList<>(); 
	        headersList.add("Employee ID");
	        headersList.add("Date");

	        List<List<String>> rowsList = new ArrayList<>();
            List<String> row = new ArrayList<>(); 
            row.add(employeeDetails.getEmployeeId());
            row.add(employeeDetails.getDate());
            rowsList.add(row);
	        
	        employeeDetailsString.add(tableEmployeeInformation.generateTable(headersList, rowsList));
	       
			TableGenerator tableGeneratorTicketInformation = new TableGenerator();
	        headersList.clear();
	        headersList.add("Ticket Level");
	        headersList.add("Count");
	        rowsList.clear();

	        while(resultset.next()) 
	    	{
	            List<String> ticketDetailRow = new ArrayList<>(); 
	            ticketDetailRow.add(resultset.getString("ticketLevel"));
	            ticketDetailRow.add(resultset.getString("count"));
	        	System.out.print(ticketDetailRow);
	            rowsList.add(ticketDetailRow);
	    	}
	        
	        employeeDetailsString.add(tableEmployeeInformation.generateTable(headersList, rowsList));

			return employeeDetailsString;
		}
		
		
		public ArrayList<String> displayEmployeeEfficiency(HashMap <Integer, Integer> calculatedEmployeeEfficiency) 
		{
			employeeDetailsString.add("################ Month Wise Efficiency ################");
			TableGenerator tableGeneratorEmployeeEfficiency = new TableGenerator();
	        List<String> headersList = new ArrayList<>();
			headersList.clear();
	        headersList.add("Month");
	        headersList.add("Efficiency");
	        List<List<String>> rowsList = new ArrayList<>();
	        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	        
	        for(int i=0;i<12;i++)
	        {
	            if(calculatedEmployeeEfficiency.containsKey(i))
				{	
		            List<String> ticketDetailRow = new ArrayList<>(); 
		            ticketDetailRow.add(monthString[i]);
		            ticketDetailRow.add(calculatedEmployeeEfficiency.get(i).toString());
		            rowsList.add(ticketDetailRow);
				}
	        }
	    	System.out.print(calculatedEmployeeEfficiency);
	        employeeDetailsString.add(tableGeneratorEmployeeEfficiency.generateTable(headersList, rowsList));
	        employeeDetailsString.add(barchart.Displaybarchart(calculatedEmployeeEfficiency));
			return employeeDetailsString;
		}
		
		public ArrayList<String> displayEmployeeProductivity(HashMap <Integer, Integer> calculatedEmployeeProductivity)  
		{
			employeeDetailsString.add("################ Month Wise Productivity ################");
			TableGenerator tableGeneratorEmployeeProductivity = new TableGenerator();
	        List<String> headersList = new ArrayList<>();
			headersList.clear();
	        headersList.add("Month");
	        headersList.add("Productivity");
	        List<List<String>> rowsList = new ArrayList<>();
	        String[] monthString = new String[]{"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
	        
	        for(int i=0;i<12;i++)
	        {
	            if(calculatedEmployeeProductivity.containsKey(i))
				{	
		            List<String> ticketDetailRow = new ArrayList<>(); 
		            ticketDetailRow.add(monthString[i]);
		            ticketDetailRow.add(calculatedEmployeeProductivity.get(i).toString());
		            rowsList.add(ticketDetailRow);
				}
	        }
	    	
	        employeeDetailsString.add(tableGeneratorEmployeeProductivity.generateTable(headersList, rowsList));
			employeeDetailsString.add(barchart.Displaybarchart(calculatedEmployeeProductivity));
			
			employeePerformanceReport = employeePerformanceFactory.getExportEmployeePerformanceReport(inputOutputHandler, employeeDetailsString);
			employeePerformanceReport.exportTicket();
			return employeeDetailsString;
		}
}