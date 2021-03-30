package userinterface;
import employeeMilestones.abstractFactory.*;
import employeeMilestones.interfaces.IEmployeeMilestone;
import java.util.Map;
public class EmployeeMilestoneScreen implements IEmployeeMilestoneScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final EmployeeMilestoneFactory employeeMilestoneFactory = new EmployeeMilestoneFactoryImplementation();

    public  EmployeeMilestoneScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }
    public void displayEmployeeMileStoneScreen() {
        String employeeID;
        Map<String, String> output;
        IEmployeeMilestone employeeMilestone;

        inputOutputHandler.displayMethod("Enter employee ID:\n");
        employeeID = inputOutputHandler.input();
        employeeMilestone = employeeMilestoneFactory.getEmployeeMilestone();
        output = employeeMilestone.getEmployeeMilestone(employeeID);

        if (output == null)
        {
            inputOutputHandler.displayMethod("No data found for " + employeeID+"\n");
        }
        else
        {
            for(Map.Entry<String, String> outputRecord : output.entrySet())
            {
                inputOutputHandler.displayMethod(outputRecord.getKey() +"\n"+outputRecord.getValue()+"\n");
            }
            inputOutputHandler.displayMethod("\n");
        }
    }
}
