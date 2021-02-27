package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	Connection connect = null;
		public Connection connectDB() throws ClassNotFoundException {
			
			String database = null;
			String username = null;
			String password = null;
			database = "jdbc:mysql://db-5308.cs.dal.ca:3306/CSCI5308_2_DEVINT?serverTimezone=UTC";
			username = "CSCI5308_2_DEVINT_USER";
		    password = "EwsTSqCdFPubhD8n";
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
	            try {
	            	connect = DriverManager.getConnection(database, username, password);		//connecting to database
	            } catch (SQLException ex) {
	            	System.out.print(ex);
	                System.out.println("Failed to create the database connection."); 
	            }
		    } catch (ClassNotFoundException ex) {
		            System.out.println("Driver not found."); 
		    }
			return connect;
		   }
		public void closeConnection() {
			// TODO Auto-generated method stub
				
			try {
				connect.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}