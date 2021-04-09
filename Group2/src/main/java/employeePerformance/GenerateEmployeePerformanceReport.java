package employeePerformance;

import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import employeePerformance.Interfaces.IBarChartGeneration;
import employeePerformance.Interfaces.IFetchedPerformanceDetails;
import employeePerformance.Interfaces.IGenerateEmployeePerformanceReport;
import employeePerformance.Interfaces.IInputEmployeeDetails;
import employeePerformance.abstractFactory.EmployeePerformanceFactory;
import employeePerformance.abstractFactory.IEmployeePerformanceFactory;
import userinterface.IInputOutputHandler;

public class GenerateEmployeePerformanceReport implements IGenerateEmployeePerformanceReport
{	
		
	    private IEmployeePerformanceFactory employeePerformanceFactory = EmployeePerformanceFactory.instance();
		private IBarChartGeneration barchart;
		private IInputOutputHandler inputOutputHandler;
		
		public GenerateEmployeePerformanceReport(IInputOutputHandler inputOutputHandler)
		{
			this.inputOutputHandler = inputOutputHandler;
		}
		
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	    
		public ArrayList<String> displayEmployeeDetailsAndTicketCount( IInputEmployeeDetails employeeDetails, ArrayList<IFetchedPerformanceDetails> fetchedPerformanceDetails) throws SQLException, ParseException
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>();

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
	       
	        headersList.clear();
	        headersList.add("Ticket Level");
	        headersList.add("Count");
	        rowsList.clear();

	        for(int i = 0; i < fetchedPerformanceDetails.size(); i++) 
	    	{
	            ArrayList<String> ticketDetailsRow = new ArrayList<>();
				ticketDetailsRow.add(fetchedPerformanceDetails.get(i).getTicketLevel());
	            ticketDetailsRow.add(fetchedPerformanceDetails.get(i).getCount());
	            
	            rowsList.add(ticketDetailsRow);
	    	}
	        
	        employeeDetailsString.add(tableEmployeeInformation.generateTable(headersList, rowsList));

			return employeeDetailsString;
		}
		
		
		public ArrayList<String> displayEmployeeEfficiency(HashMap <Integer, Integer> calculatedEmployeeEfficiency) 
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>();

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

	        employeeDetailsString.add(tableGeneratorEmployeeEfficiency.generateTable(headersList, rowsList));
	        barchart = employeePerformanceFactory.getbarchartGeneration(inputOutputHandler);
	        employeeDetailsString.add(barchart.Displaybarchart(calculatedEmployeeEfficiency));

			return employeeDetailsString;
		}
		
		public ArrayList<String> displayEmployeeProductivity(HashMap <Integer, Integer> calculatedEmployeeProductivity)  
		{
			ArrayList<String> employeeDetailsString = new ArrayList<String>();

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
			inputOutputHandler.displayMethod("Successfully created Employee Performance Report");
			return employeeDetailsString;
		}
}