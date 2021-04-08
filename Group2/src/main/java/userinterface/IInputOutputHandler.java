package userinterface;

public interface IInputOutputHandler {
	public void displayMethod(String printMessage);

	public String input();

	public int inputInt();

	public void closeScanner();
}
