package employeeEfficiency;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import employeeEfficiency.Interfaces.IGenerateEmployeePerformanceReport;
import employeeEfficiency.Interfaces.IInputEmployeeDetails;

public class GenerateEmployeePerformanceReport implements IGenerateEmployeePerformanceReport
{	
		private ArrayList <String> employeeDetailsString = new ArrayList<String>();
		private IInputEmployeeDetails employeeDetails = null;
		private ExportEmployeePerformanceReport employeePerformanceReport = new ExportEmployeePerformanceReport(employeeDetailsString) ;
		private BarChartGeneration barchart = new BarChartGeneration();
		
		public GenerateEmployeePerformanceReport(IInputEmployeeDetails employeeDetails)
		{
			this.employeeDetails = employeeDetails;
		}

		public boolean displayEmployeeDetailsAndTicketCount(ResultSet resultset) throws SQLException, ParseException
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
	        
	        System.out.println(tableEmployeeInformation.generateTable(headersList, rowsList));
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
	            rowsList.add(ticketDetailRow);
	    	}
	        
	        System.out.println(tableGeneratorTicketInformation.generateTable(headersList, rowsList));
	        employeeDetailsString.add(tableEmployeeInformation.generateTable(headersList, rowsList));

			return false;
		}
		
		
		public void displayEmployeeEfficiency(HashMap <Integer, Integer> calculatedEmployeeEfficiency) 
		{
			System.out.print("################ Month Wise Efficiency ################");
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
	    	
	        System.out.println(tableGeneratorEmployeeEfficiency.generateTable(headersList, rowsList));
	        employeeDetailsString.add(tableGeneratorEmployeeEfficiency.generateTable(headersList, rowsList));
	        employeeDetailsString.add(barchart.Displaybarchart(calculatedEmployeeEfficiency));
			return ;
		}
		
		public void displayEmployeeProductivity(HashMap <Integer, Integer> calculatedEmployeeProductivity)  
		{
			System.out.print("################ Month Wise Productivity ################");
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
	    	
	        System.out.println(tableGeneratorEmployeeProductivity.generateTable(headersList, rowsList));
	        employeeDetailsString.add(tableGeneratorEmployeeProductivity.generateTable(headersList, rowsList));
	        
			System.out.print(calculatedEmployeeProductivity);
			employeeDetailsString.add(barchart.Displaybarchart(calculatedEmployeeProductivity));
			employeePerformanceReport.exportTicket();

			return;
		}
}


