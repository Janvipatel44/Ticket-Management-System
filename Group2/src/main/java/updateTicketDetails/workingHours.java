package updateTicketDetails;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import updateTicketDetails.interfaces.IworkingHours;


public class workingHours implements IworkingHours {
	
	private ResultSet resultset;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  

	public workingHours(ResultSet resultset) {
		this.resultset = resultset;
	}
	
	public double insertTicket(ResultSet resultset) throws SQLException
	{
		String previousDate = null;
		Time previousTime = null;
		Date todayDate = null;
	    double hours = 0;
	    String inProgressEnterdate = null;
		Date formateGetDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    

		while(resultset.next()) 	
    	{
			//String status = resultset.getString("status");
			//System.out.print(status);
			//if(status=="done") {
				/*if(status !=null) 
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
				}*/
			
		   		    

				previousDate = resultset.getString("previousDate");
			    System.out.print("Previous Date" +previousDate);

				try {
					formateGetDate  = sdf.parse(previousDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	    		
			    try {
					todayDate = sdf.parse(sdf.format(cal.getTime()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


	    	    long dateDifferenceInMinutes = Math.abs(formateGetDate.getTime() - todayDate.getTime());
			    long minutes = TimeUnit.MILLISECONDS.toMinutes(dateDifferenceInMinutes);
			    hours = minutes/(float)60;
			    System.out.print("Hours total" +hours);
    	}
		return hours;
	}
}
