package userinterface;
import login.Interfaces.*;
import login.abstractfactory.*;
import menucontroller.MenuHandler;
import menucontroller.abstractfactory.*;
import menucontroller.interfaces.IMenuHandler;
import userinterface.abstractFactory.*;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import insertTicket.EnumValidation;
import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.IInsertTicket;
import insertTicket.abstractFactory.IInsertTicketFactory;
import insertTicket.abstractFactory.InsertTicketFactory;

public class GenerateTicketScreen implements IGenerateTicketScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final IUserInterfaceFactory userInterfaceFactory;
    private IBackToHomePageScreen backToHomePageScreen;
    
    private IInsertTicketFactory insertTicketFactory = InsertTicketFactory.instance();
	private IInsertTicket insertTicket;
    private ICreateTicket createTicket;

    public GenerateTicketScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        this.userInterfaceFactory = UserInterfaceFactory.instance();
    }
    
    //IParameterizedUser user;
    public void displayTicketGenerationScreen()
    {
		String ticketID = null;
	    String description = null;
	    String expectedEndDate = null;
	    String reporterID = null;
	    String employeeID = null;
	    String assigneeName = null;
	    String ticketType = null;    
	    String ticketStatus = null;		    
	    int priority = 0;
	    int urgency = 0;
	    int impact = 0;
	    String ticketLevel = null;		    
	    String customerID = null;
	    String customerName = null;
	    String creatorID = null;
	    String creatorName = null;
	   	int validInput = -1;	 
	   	
	   	ticketID = displayGenerateTicketScreenController(validInput,"ticketID",EnumValidation.validateTicketID);
	   	description = displayGenerateTicketScreenController(validInput,"description",EnumValidation.validateTicketID);
	   	expectedEndDate = displayGenerateTicketScreenController(validInput,"expectedEndDate",EnumValidation.validateTicketID);
	   	reporterID = displayGenerateTicketScreenController(validInput,"reporterID",EnumValidation.validateTicketID);
	   	employeeID = displayGenerateTicketScreenController(validInput,"employeeID",EnumValidation.validateTicketID);
	   	assigneeName = displayGenerateTicketScreenController(validInput,"assigneeName",EnumValidation.validateTicketID);
	   	ticketType = displayGenerateTicketScreenController(validInput,"ticketType",EnumValidation.validateTicketID);
	   	ticketStatus = displayGenerateTicketScreenController(validInput,"ticketStatus",EnumValidation.validateTicketID);
	   	priority = Integer.parseInt(displayGenerateTicketScreenController(validInput,"priority",EnumValidation.validateTicketID));
	   	urgency = Integer.parseInt(displayGenerateTicketScreenController(validInput,"urgency",EnumValidation.validateTicketID));
	   	impact = Integer.parseInt(displayGenerateTicketScreenController(validInput,"impact",EnumValidation.validateTicketID));
	   	ticketLevel = displayGenerateTicketScreenController(validInput,"ticketLevel",EnumValidation.validateTicketID);
	   	customerID = displayGenerateTicketScreenController(validInput,"customerID",EnumValidation.validateTicketID);
	   	customerName = displayGenerateTicketScreenController(validInput,"customerName",EnumValidation.validateTicketID);
	   	creatorID = displayGenerateTicketScreenController(validInput,"creatorID",EnumValidation.validateTicketID);
	   	creatorName = displayGenerateTicketScreenController(validInput,"creatorName",EnumValidation.validateTicketID);

	    createTicket = insertTicketFactory.getcreateTicket(ticketID, description, expectedEndDate, reporterID,
	    		employeeID, assigneeName, ticketType, ticketStatus, priority, urgency, impact, ticketLevel, customerID, 
	    		customerName, creatorID, creatorName);
	   
        inputOutputHandler.displayMethod("\n");
	   	

	    insertTicket = insertTicketFactory.insertTicket(createTicket);
	    try 
	    {
			if(insertTicket.successfulInsertion()==true) 
			{
	            inputOutputHandler.displayMethod("Ticket generation successful.");
			}
			else 
			{
	            inputOutputHandler.displayMethod("Ticket generation failed");
			}
		}
	    catch (ParseException e) 
	    {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}      
	   // backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
       // backToHomePageScreen.displayGoBackToHomePageOption(user);
    }
    
    public String displayGenerateTicketScreenController(int validInput, String inputType, EnumValidation validationString)
    {
    	String inputString = null;
    	String inputMessage = null;
    	String errorMessage = null;
        inputMessage = "Enter " + inputType + ":\n";
        errorMessage = "Please enter valid" + inputType;
               
    	while(validInput != 0) 
    	{
    	    inputOutputHandler.displayMethod(inputMessage);
    	    inputString = inputOutputHandler.input();
    	    
		    if(insertTicketFactory.validation().validation(inputString,validationString) == false) 
		    {
	            inputOutputHandler.displayMethod(errorMessage);
		    	validInput = 1;
		    }
		    else 
		    {
		    	validInput = 0;
		    }
		    if(validInput == 1) 
		    {
	    	    inputOutputHandler.displayMethod("Exit? (Yes/No)");
	    	    inputString = inputOutputHandler.input();
	    	    if(inputString == "Yes") 
	    	    {
	    	    	//backToHomePageScreen = userInterfaceFactory.getBackToHomePageScreen(inputOutputHandler);
	    	        //backToHomePageScreen.displayGoBackToHomePageOption(user);
	    	    }
	    	    else 
	    	    {
	    	    	validInput = 0;
	    	    }
		    }
    	}
    	return inputString;
    }
}