package userinterface;

import insertTicket.EnumValidation;
import login.Interfaces.IParameterizedUser;

public interface IGenerateTicketScreen 
{
    public void displayTicketGenerationScreen();
    public String displayGenerateTicketScreenController(int validInput, String inputType, EnumValidation validationString);
}
