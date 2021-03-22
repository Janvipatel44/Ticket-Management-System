package database;
import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionManager implements IConnectionManager{
	 private static String driverName = "com.mysql.cj.jdbc.Driver";   
		private Connection connection = null;
		private String configurationFile = null;

		public ConnectionManager(String ConfigurationFile){
			this.configurationFile = ConfigurationFile;
		}
	     
		public Connection establishConnection() {
			// TODO Auto-generated method stub
	        System.out.println("Connection done");

			try {

	        List<String> details = new ArrayList<>();								
			
		    if(configurationFile.equals(null) || configurationFile.equals("")) {	
				System.out.print("Invalid Configuration File name");
				return null;
			}
			FileReader deviceDetails = null;
			deviceDetails = new FileReader(configurationFile);					//File reader object
	        BufferedReader bfr_reader=new BufferedReader(deviceDetails);   			
			while (bfr_reader.ready()) {	
				String line = bfr_reader.readLine();				  
				details.add(line);	
			}
			String database = details.get(0);
			String username = details.get(1);
			String password = details.get(2);
			
			deviceDetails.close();
	        Class.forName(driverName);
	        connection = DriverManager.getConnection(database, username, password);		
	        System.out.println("Connection done");
			}
	        catch (SQLException ex) {
	            	System.out.print(ex);
	                System.out.println("Failed to create the database connection."); 
	        }
		    catch (ClassNotFoundException ex) {
		            System.out.println("Driver not found."); 
		    }
			catch (FileNotFoundException e) {
	            System.out.println("Invalid configuration file");
	        }
	        catch (IOException e) {
	            System.out.println("Issue occured while reading configuration file.");
	        } 
			return connection;
		}
		public void closeConnection() {
			// TODO Auto-generated method stub
				
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
