package searchingFunctionality;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.CallableStatement;
import DBConnection.DBConn;

public class searchTicket {
	DBConn obj=new DBConn();
	private Connection connect=null;
	private CallableStatement SPstatement=null;
	private ResultSet resultSet=null;
	private boolean hasResult=false;
	private searchedOutput callObj=new searchedOutput();
	public void searchbyTicketId(int id) throws ClassNotFoundException {
		
		
			connect = obj.connectDB();
			try {
				SPstatement = connect.prepareCall("{call searchbyTicketID(?)}");
				SPstatement.setInt(1, id);
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

	public void searchbyTicketAssignee(String assigneeName) {
		
		try {
			connect = obj.connectDB();
			SPstatement = connect.prepareCall("{call searchbyAssignee(?)}");
			SPstatement.setString(1, assigneeName);
			hasResult=SPstatement.execute();
			if(hasResult) {
				resultSet = SPstatement.getResultSet();
				callObj.displaySearchedOutput(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchbyTickettype(String ticketType) {
		try {
			connect = obj.connectDB();
			SPstatement = connect.prepareCall("{call searchbyTicketType(?)}");
			SPstatement.setString(1, ticketType);
			hasResult=SPstatement.execute();
			if(hasResult) {
				resultSet = SPstatement.getResultSet();
				callObj.displaySearchedOutput(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void searchbyAllTicket() {
		
		try {
			connect = obj.connectDB();
			SPstatement = connect.prepareCall("{call searchbyAllTickets()}");
			hasResult=SPstatement.execute();
			if(hasResult) {
				resultSet = SPstatement.getResultSet();
				callObj.displaySearchedOutput(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchbyTicketCreator(String ticketCreator) {
		
		try {
			connect = obj.connectDB();
			SPstatement = connect.prepareCall("{call searchbyTicketCreator(?)}");
			SPstatement.setString(1, ticketCreator);
			hasResult=SPstatement.execute();
			if(hasResult) {
				resultSet = SPstatement.getResultSet();
				callObj.displaySearchedOutput(resultSet);
				System.out.println("called dispaly succ");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void searchbyKeyword(String keyword) {
		try {
			connect = obj.connectDB();
			SPstatement = connect.prepareCall("{call searchbyAllTickets()}");
			hasResult=SPstatement.execute();
			if(hasResult) {
				resultSet = SPstatement.getResultSet();
				callObj.displaySearchedOutput(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
