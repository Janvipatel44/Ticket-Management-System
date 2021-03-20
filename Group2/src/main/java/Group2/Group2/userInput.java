package Group2.Group2;

import java.util.Scanner;

public class userInput 
{
	public static void main(String args[])
	{
		String userRole = "Manager";
		String userInputRole = null;
		String ticketId = null;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter you role:");
		userInputRole = sc.nextLine();
		if(userRole.equals(userInputRole))
		{
			System.out.println("Enter Ticket Id you want to delete");
			ticketId = sc.nextLine();
			
		}
		
	}
}
