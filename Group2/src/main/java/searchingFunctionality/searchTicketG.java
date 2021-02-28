package searchingFunctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;

public class searchTicketG implements IsearchTicket{
	//Database connectoion
	DBConn obj=new DBConn();
	
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private searchedOutput callObj=new searchedOutput();
	
	@Override
	public void searchbyTicket(int choice, String searchtype) {
		try {
			connect = obj.connectDB();
			//Stored Procedure call that finds tickets from the system as per the user requirement 
			SPstatement = connect.prepareCall("{call searchTicket(?,?)}");
			//first parameter decided search option 
			SPstatement.setLong(1,choice);
			//second parameter passes search value
			SPstatement.setString(2,searchtype);
			hasResult=SPstatement.execute();
			if(hasResult) {
				//store tickets that matches with user requirement
			    resultSet = SPstatement.getResultSet();
			    System.out.println("hasresult:"+hasResult + "resultset:"+resultSet );
			    //pass string to display tickets on user screen
				callObj.displaySearchedOutput(resultSet);
			}
			else {
				//tickets with given searching parameter is not exist in the system.
				System.out.println("Ticket does not exist");
			}
			//close DB connection
			obj.closeConnection();
			
		} 
		catch (SQLException e) {
				e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
