package userinterface;

import java.util.Scanner;

public class InputOutputHandler implements IInputOutputHandler {

	public void displayMethod(String printMessage) {
		System.out.println(printMessage);
	}

	public String input() {
		int i = -1;
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
<<<<<<< HEAD
		
=======
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
		return nextLine;
	}

	public int inputInt()
	{
		Scanner scanner = new Scanner(System.in);
		int input = scanner.nextInt();
<<<<<<< HEAD
		
=======
>>>>>>> c6eefe9a39d31e61d315bfad8c29b0da7afff01d
		return input;
	}
}
