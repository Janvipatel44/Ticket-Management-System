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


public class workingHours implements IworkingHours 
{
	
	private ResultSet resultset;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();  

	public workingHours(ResultSet resultset) {
		this.resultset = resultset;
	}
	
	public double insertTicket(ResultSet resultset) throws SQLException
	{
		String previousDate = null;
		Date todayDate = null;
	    double hours = 0;
		Date formateGetDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();

		while(resultset.next()) 	
    	{
				previousDate = resultset.getString("previousDate");
			    System.out.print("Previous Date" +previousDate);

				try {
					formateGetDate  = sdf.parse(previousDate);
					todayDate = sdf.parse(sdf.format(cal.getTime()));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	    long dateDifferenceInMinutes = Math.abs(formateGetDate.getTime() - todayDate.getTime());
			    long minutes = TimeUnit.MILLISECONDS.toMinutes(dateDifferenceInMinutes);
			    hours = minutes/(float)60;
			    System.out.print("Hours total" +hours);
    	}
		return hours;
	}
}
