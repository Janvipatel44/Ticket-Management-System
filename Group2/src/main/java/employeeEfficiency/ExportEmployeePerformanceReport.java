package employeeEfficiency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class ExportEmployeePerformanceReport {
	private String FileName = null;
	private Scanner sc = new Scanner(System.in);
	private ArrayList<String> employeeDetailsString = new ArrayList<String>();

	public ExportEmployeePerformanceReport(ArrayList<String> employeeDetailsString) {
		this.employeeDetailsString = employeeDetailsString;
	}

	public void exportTicket() throws InvalidPasswordException, IOException 
	{				
		System.out.println("Enter file name with Path:"); //FileName=sc.next();
		//PdfWriter pdfwriter = new PdfWriter(path); File myObj = new
				  
	}
}
