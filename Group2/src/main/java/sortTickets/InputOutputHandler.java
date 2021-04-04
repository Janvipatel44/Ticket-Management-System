package sortTickets;

import java.util.Scanner;

import sortTickets.interfaces.IInputOutputHandler;

public class InputOutputHandler implements IInputOutputHandler {

	public void displayMethod(String printMessage) 
	{
		System.out.println(printMessage);
	}

	public String input() 
	{
		int i = -1;
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		return nextLine;
	}

	public int inputInt()
	{
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		return input;
	}
}
