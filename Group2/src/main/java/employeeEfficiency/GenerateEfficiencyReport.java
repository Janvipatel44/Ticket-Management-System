package employeeEfficiency;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class GenerateEfficiencyReport implements IGenerateEfficiencyReport
{	
	ArrayList <String> employeeEfficiency = new ArrayList<String>();

	public boolean displayEmployeeDetails(Resultset resultSet) {
		// TODO Auto-generated method stub
		
	/*	try {
			int i=0;	        
			while (resultSet.next()) {	
			  	 System.out.println(resultSet.getString("employeeId")+ " "
			   		+resultSet.getString("Date");			   	
					
			  		employeeEfficiency.addAll(new ArrayList());	    
			  		employeeEfficiency.get(i).add(0,resultSet.getString("employeeId"));
			  		employeeEfficiency.get(i).add(1,resultSet.getString("Date"));
				
				 i++;
			}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(employeeEfficiency.size()==0) {
				System.out.println("Empty");
				return false;
			}else {
				System.out.println("Select Option:");
				System.out.println("1. Export Tickets");
				System.out.println("2. exit:");
			    int choice = 0;
			    Scanner sc=new Scanner(System.in);
			    choice=sc.nextInt();
				if(choice==1) {
					IexportTicket obj=new exportTicket();
					obj.exportTicket(ticketsData);
				}else {
					System.out.println("exit");
				}
				return true;
			}
			
		}	*/

		return false;
	}

}
