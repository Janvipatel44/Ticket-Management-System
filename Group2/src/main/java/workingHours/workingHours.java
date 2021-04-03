package workingHours;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;


public class workingHours implements IworkingHours {
	
	private ResultSet resultset;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  

	public workingHours(ResultSet resultset) {
		this.resultset = resultset;
	}
	
	public double insertTicket(ResultSet resultset) throws SQLException
	{
		java.sql.Date startDate = null;
		Time startTime = null;

	    double Now= 0;
	    double PreviousHours = 0;
		while(resultset.next()) 	
    	{
			String status = resultset.getString("status");
			System.out.print(status);
			if(status=="done") {
				if(status !=null) 
				{
		    		System.out.println("\nStart Date:" );
	
		    		System.out.println("\nStart Date:" +resultset.getDate("previousDate"));
		    	    startDate = resultset.getDate("previousDate");
					startTime = resultset.getTime("previousDate");
	
		    		System.out.println("\nTicketStatus:" +resultset.getString("status"));
		    		System.out.println("\nWork In Progress:" +resultset.getDouble("ticketInProgressHours"));
		    	    PreviousHours = resultset.getDouble("ticketInProgressHours");
				}
				else 
				{
					startDate = resultset.getDate("startDate");
					startTime = resultset.getTime("startDate");
				}
	    		LocalDateTime now = LocalDateTime.now();      	    
	    	    System.out.print(now.toLocalDate());
	    	    
	    	    double dayDifference = ChronoUnit.DAYS.between(now.toLocalDate(),startDate.toLocalDate());
	    	    System.out.print("\n Now:" +now.toLocalTime().getHour());
	    	    double startHour = 18-(startTime.toLocalTime().getHour());	   
	    	    System.out.print("\n Now:" +startHour);
	
	    	    double endHour = 18-now.toLocalTime().getHour();
	    	    if(dayDifference==0) {
	    	    	Now = now.toLocalTime().getHour() - startHour;
	        	    System.out.print("\n Hours:" +Now);
	    	    }
	    	    else if(dayDifference>0) {
	    	    	
	    	    	Now = endHour + startHour;
	        	    System.out.print("\n Now:" +Now);
	    	    }
	    	    else if (dayDifference>1) 
	    	    {
	    	    	Now = endHour + startHour + (dayDifference-1)*8;
	        	    System.out.print("\n Now:" +Now);
	    	    }
	    	    if(resultset.getString("status")!=null && resultset.getString("status")!="done") {
	    	    	Now = PreviousHours + Now;
	    	    }
			}
    	}
		return Now;
		
	}
}
