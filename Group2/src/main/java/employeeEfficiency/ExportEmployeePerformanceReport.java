package employeeEfficiency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExportEmployeePerformanceReport implements IExportEmployeePerformanceReport {
	private String FileName = null;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<String> employeeDetailsString = new ArrayList<String>();

	public ExportEmployeePerformanceReport(ArrayList<String> employeeDetailsString) {
		this.employeeDetailsString = employeeDetailsString;
	}
	
	@Override
	public void exportTicket() {
		System.out.println("Enter file name with Path:");
		FileName=sc.next();
		File myObj = new File(FileName);
	      try {
			if (myObj.createNewFile()) {
				  FileWriter myWriter = new FileWriter(FileName);
				  for(String employeedetails: employeeDetailsString) 
				  {
					  System.out.print(employeedetails);
					  myWriter.write(employeedetails);
					  myWriter.write("\n");
     			  }		  
			      myWriter.close();
			}
		} 
	    catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
}
