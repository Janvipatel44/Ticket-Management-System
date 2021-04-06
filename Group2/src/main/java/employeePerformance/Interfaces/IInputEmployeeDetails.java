package employeePerformance.Interfaces;

import java.text.ParseException;
import java.util.Date;

public interface IInputEmployeeDetails 
{
	public String getEmployeeId();

    public String getDate() throws ParseException;
    public Date generateDateFormat() throws ParseException;

}
