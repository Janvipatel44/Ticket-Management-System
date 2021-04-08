package userinterface;

import java.util.Scanner;

public class InputOutputHandler implements IInputOutputHandler {

//	private Scanner scanner;

	//public InputOutputHandler() {
		//scanner = new Scanner(System.in);
//	}

	public void displayMethod(String printMessage) {
		System.out.println(printMessage);
	}

	public String input() {
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		scanner.close();
		return nextLine;
		
	}

	public int inputInt() {
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
		scanner.close();
		return input;
	}

	//public void closeScanner() {
		//scanner.close();
//	}
}
