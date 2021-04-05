package reuseablePackage;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import database.ConnectionManager;
import database.IConnectionManager;
import reuseablePackage.interfaces.IticketStatusInProgress;

public class ticketStatusInProgress implements IticketStatusInProgress 
{
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	static String fileName = "ConfigurationFile";
	private double hours = -1;
	private IConnectionManager ConnectionMng=new ConnectionManager(fileName);
	
	public ticketStatusInProgress(IConnectionManager ConnectionMng) 
	{
		this.ConnectionMng=ConnectionMng;
	}
	
	public double calculateHours(String ticketID)
	{
		String inProgressEnterdate = null;
		Date todayDate = null;
		Date formateGetDate = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    Calendar cal = Calendar.getInstance();
	    
		
		try
		{
			connect = ConnectionMng.establishConnection();
			SPstatement = connect.prepareCall("{call getTicketInProgressDate(?,?)}");
			SPstatement.setString(1,ticketID);
			SPstatement.registerOutParameter(2, java.sql.Types.DATE);
			SPstatement.execute();
			
			inProgressEnterdate = SPstatement.getString(2);
		    formateGetDate  = sdf.parse(inProgressEnterdate);
		    todayDate = sdf.parse(sdf.format(cal.getTime()));
		    
		    long dateDifferenceInMinutes = Math.abs(formateGetDate.getTime() - todayDate.getTime());
		    long minutes = TimeUnit.MILLISECONDS.toMinutes(dateDifferenceInMinutes);
		    hours = minutes/(float)60;
		    
		    return hours;
		} 
		catch (SQLException | ParseException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			 return hours;
		}
		
	}
}
