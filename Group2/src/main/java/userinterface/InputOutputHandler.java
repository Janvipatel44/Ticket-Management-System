package userinterface;

import java.util.Scanner;

public class InputOutputHandler implements IInputOutputHandler {

	private Scanner scanner;

	public InputOutputHandler()
	{
		scanner = new Scanner(System.in);
	}

	public void displayMethod(String printMessage) {
		System.out.println(printMessage);
	}

	public String input() {
		int i = -1;
		String nextLine = scanner.nextLine();

		return nextLine;
	}

	public int inputInt()
	{
		int input = scanner.nextInt();

		return input;
	}

	public void closeScanner()
	{
		scanner.close();
	}
}
