package employeeEfficiency;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Resultset;

import database.ConnectionManager;
import database.IConnectionManager;

public class EmployeeDetailsDB implements IEmployeeDetailsDB {

	private Connection connection;
	private String ConfigurationFile = "ConfigurationFile.txt";
 
	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);
	IGenerateEfficiencyReport efficiencyReport = new GenerateEfficiencyReport();
    EmployeeEfficiencyCalculation employeeEfficiency = new EmployeeEfficiencyCalculation();

	private final IInputEmployeeDetails employeeDetails;

	public EmployeeDetailsDB(IInputEmployeeDetails employeeDetails)
    {
        this.employeeDetails = employeeDetails;
    }
	
	public boolean ticketCounts()
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
        boolean hasResult = false;
        ResultSet resultset = null;

		try {  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call ticketCount(?, ?)}");
			
			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setDate(2, java.sql.Date.valueOf(employeeDetails.getDate()) );
            hasResult = statement.execute();
           
	        System.out.print(hasResult); 
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	while(resultset.next()) {
            		System.out.println("Ticket Level:" +resultset.getString("ticketLevel"));
            		System.out.println("Count:" +resultset.getString("count"));
		        } 
            }
			return true;
		
		} catch (SQLException e) {
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	
	public boolean employee_Efficiency() throws ParseException
	{
		connection = IConnectionMng.establishConnection();
        boolean success=false;
        boolean hasResult = false;
        ResultSet resultset = null;
		try {  
			CallableStatement statement = (CallableStatement) connection.prepareCall("{call efficiency_Employee(?, ?)}");
			
			statement.setString(1, employeeDetails.getEmployeeId());
            statement.setDate(2, java.sql.Date.valueOf(employeeDetails.getDate()) );
            hasResult = statement.execute();
           
	        System.out.print(hasResult); 
            if(hasResult)  
            {  
            	resultset = statement.getResultSet();
            	employeeEfficiency.employee_Efficiency(resultset);
            }
			return true;
		
		} catch (SQLException e) {
			System.out.print("SQL Exception");
			e.printStackTrace();
		}
        return success;
	}	

}
