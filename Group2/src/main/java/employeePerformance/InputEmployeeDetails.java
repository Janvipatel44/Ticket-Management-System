package employeePerformance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import employeePerformance.Interfaces.IInputEmployeeDetails;

public class InputEmployeeDetails implements IInputEmployeeDetails
{
    private String employeeId = null;
    private String date = null;
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 

    public InputEmployeeDetails(String date, String employeeId){
    	this.date = date;
    	this.employeeId = employeeId;
    }
    public String getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }
    
    public Date generateDateFormat() throws ParseException {
        date = getDate();
    	Date newdate = (Date)formatter.parseObject(date);
        return newdate;
    }
    
}
