package userinterface;
import customerAnalysis.Interfaces.ICustomerAnalysis;
import customerAnalysis.abstractFactory.CustomerAnalysisFactory;
import customerAnalysis.abstractFactory.CustomerAnalysisFactoryImplementation;
import java.util.Map;
public class CustomerAnalysisScreen implements ICustomerAnalysisScreen
{
    private final CustomerAnalysisFactory customerAnalysisFactory = new CustomerAnalysisFactoryImplementation();
    private final IInputOutputHandler inputOutputHandler;

    public CustomerAnalysisScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }

    public void displayCustomerAnalysisScreen()
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
