package userinterface;
import customerAnalysis.Interfaces.ICustomerAnalysis;
import customerAnalysis.Interfaces.IParameterizedCustomerTicket;
import customerAnalysis.abstractfactory.CustomerAnalysisFactory;
import customerAnalysis.abstractfactory.ICustomerAnalysisFactory;
import login.Interfaces.IParameterizedUser;

import java.util.Map;
public class CustomerAnalysisScreen implements ICustomerAnalysisScreen
{
    private final ICustomerAnalysisFactory customerAnalysisFactory = CustomerAnalysisFactory.instance();
    private final IInputOutputHandler inputOutputHandler;

    public CustomerAnalysisScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayCustomerAnalysisScreen(IParameterizedUser user)
    {
        String customerID;
        Map<String, String> outputResult;
        ICustomerAnalysis customerAnalysis = customerAnalysisFactory.getCustomerAnalysis();

        inputOutputHandler.displayMethod("Enter customer ID:\n");
        customerID = inputOutputHandler.input();
        outputResult = customerAnalysis.getCustomerAnalysis(customerID);

        if(outputResult == null)
        {
            inputOutputHandler.displayMethod("No data found for "+customerID);
        }
        else
        {
            for(Map.Entry<String, String> outputRecord : outputResult.entrySet())
            {
                inputOutputHandler.displayMethod(outputRecord.getKey()+"\n"+outputRecord.getValue()+"\n");
            }
            inputOutputHandler.displayMethod("\n");
        }
    }
}
