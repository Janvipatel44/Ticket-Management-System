package login;
import com.group2.userinterface.IInputOutputHandler;
import database.IDatabaseUserRegistrationOperations;
public class Registration implements IRegister
{
    private final IDatabaseUserRegistrationOperations userRegistrationOperations;
    private final IInputOutputHandler inputOutputHandler;
    private final IEncryption encryption;
    private final String passwordRegExp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,100}(?=.[@#&*!$%])";
    private boolean result = false;

    public Registration(IDatabaseUserRegistrationOperations userRegistrationOperations, IInputOutputHandler inputOutputHandler, IEncryption encryption)
    {
        this.userRegistrationOperations = userRegistrationOperations;
        this.inputOutputHandler = inputOutputHandler;
        this.encryption = encryption;
    }

    public boolean registerUser(String employeeID, String firstName, String lastName, String email, String user_password, String user_type)
    {
        if(userRegistrationOperations.checkDuplicateEmployeeID(employeeID))
        {
            inputOutputHandler.displayMethod("Error: Duplicate employee ID found. Please use a different employee ID and try again.");
            return result;
        }
        else
        {
            if(user_password.matches(passwordRegExp))
            {
                user_password = encryption.encryptPassword(user_password);
                userRegistrationOperations.registerUserDatabase(employeeID, firstName, lastName, email, user_password, user_type);
                return result = true;
            }
            else
            {
                inputOutputHandler.displayMethod("Error: Password does not match the requirements. \nA password must be at least 8 characters, must contain a special character (@,!,#,$,%,&,*), must be 8 to 100 characters in length, must contain at least one lower case and one upper case letter");
                return result = false;
            }
        }
    }
}