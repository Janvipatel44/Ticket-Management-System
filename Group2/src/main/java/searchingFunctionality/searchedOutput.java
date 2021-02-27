package searchingFunctionality;

import java.sql.ResultSet;
import java.sql.SQLException;

public class searchedOutput {
	public void displaySearchedOutput(ResultSet resultSet) {
		try {
			while (resultSet.next()) {
			    System.out.println(resultSet.getInt("ticketId") + " "+ resultSet.getString("description")
			    		+ " "+ resultSet.getDate("startDate")+resultSet.getDate("endDate") );
				}
			System.out.println("in dispaly succ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}	 
	}
	
