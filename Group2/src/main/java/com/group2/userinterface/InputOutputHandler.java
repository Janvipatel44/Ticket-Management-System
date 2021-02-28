package com.group2.userinterface;

import java.util.Scanner;

import validations.StringValidations;

public class InputOutputHandler implements IInputOutputHandler {

	public void displayMethod(String printMessage) {
		System.out.println(printMessage);
	}

	public String input() throws Exception {	
		int i = -1;
		Scanner scanner = new Scanner(System.in);
		String nextLine = scanner.nextLine();
		scanner.close();
		return nextLine;
	}
}
