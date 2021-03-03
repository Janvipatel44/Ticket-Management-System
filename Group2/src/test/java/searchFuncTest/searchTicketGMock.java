package searchFuncTest;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConn;
import database.ConnectionManager;
import database.IConnectionManager;
import searchingFunctionality.IsearchTicket;

public class searchTicketGMock implements IsearchTicket{
	//Database connectoion
	
	private String searchbyTicketID="2567";
	
	private String searchbyTicketAssignee="Kolol";
	private String searchbyTicketType="Service Request";
	private String searchbyTicketCreator="Reporter123";
	private String searchbyTicketKeyword="DB Connection Error";
//	private Connection connect=null;
//	private CallableStatement SPstatement=null;
//	private ResultSet resultSet=null;
//	private boolean hasResult=false;
//	private String ConfigurationFile = "ConfigurationFile";
//	private searchedOutput callObj=new searchedOutput();
//	
//	IConnectionManager IConnectionMng = new ConnectionManager(ConfigurationFile);

	public boolean searchbyTicket(int choice, String searchtype) {
		if(choice==1 && searchbyTicketID.equals(searchtype)) {
			return true;
		}else if(choice==2 && searchbyTicketAssignee.equals(searchtype)) {
			return true;
		}else if(choice==3 && searchbyTicketType.equals(searchtype)) {
			return true;
		}else if(choice==4){
			return true;
		}else if(choice==5 && searchbyTicketCreator.equals(searchtype)) {
			return true;
		}else if(choice==6 && searchbyTicketKeyword.contains(searchtype)) {
			return true;
		}else {
			return false;
		}
	}
}
