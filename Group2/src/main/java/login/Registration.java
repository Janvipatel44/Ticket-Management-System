package login;
import com.group2.userinterface.IInputOutputHandler;
import com.group2.userinterface.InputOutputHandler;
import database.ConnectionManager;
import database.IConnectionManager;
import database.IDatabaseLoginOperations;
public class Registration implements IRegister
{
    IConnectionManager connection;
    IDatabaseLoginOperations loginOperations;
    IInputOutputHandler inputOutputHandler;

    public Registration(IConnectionManager connection, IDatabaseLoginOperations loginOperations, IInputOutputHandler inputOutputHandler)
    {
        this.connection = connection;
        this.loginOperations = loginOperations;
        this.inputOutputHandler = inputOutputHandler;
    }

    @Override
    public boolean registerUser(String employeeID, String firstName, String lastName, String email, String user_password, String user_type)
    {
        if(loginOperations.checkDuplicateEmployeeID(employeeID, connection))
        {
            inputOutputHandler.displayMethod("Error: Duplicate employee ID found. Please use a different employee ID and try again.");
        }
        return false;
    }
}