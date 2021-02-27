package searchingFunctionality;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;

public class searchTicketG {
	DBConn obj=new DBConn();
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private searchedOutput callObj=new searchedOutput();
	
	public void searchbyTicketId(int choice,String searchtype) throws ClassNotFoundException {
		connect = obj.connectDB();
		
		try {
			SPstatement = connect.prepareCall("{call searchTicket(?,?,?,?,?)}");
				SPstatement.setString(choice, searchtype);
				hasResult=SPstatement.execute();
			if(hasResult) {
				resultSet = SPstatement.getResultSet();
				callObj.displaySearchedOutput(resultSet);
				System.out.println("called dispaly succ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// process result set

}

}
