package userinterface;
import employeeMilestones.abstractFactory.*;
import employeeMilestones.interfaces.IEmployeeMilestone;
import java.util.Map;

public class EmployeeMilestoneScreen implements IEmployeeMilestoneScreen
{
    InputOutputHandler inputOutputHandler;
    EmployeeMilestoneFactory employeeMilestoneFactory = new EmployeeMilestoneFactoryImplementation();
    Map<String, String> output;

    public  EmployeeMilestoneScreen(InputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
    }
    public void displayEmployeeMileStoneScreen()
    {
        inputOutputHandler.displayMethod("Enter employee ID:\n");
        String employeeID = inputOutputHandler.input();
        IEmployeeMilestone employeeMilestone = employeeMilestoneFactory.getEmployeeMilestone();
        output = employeeMilestone.getEmployeeMilestone(employeeID);
        for(Map.Entry<String, String> outputRecord : output.entrySet())
        {
            inputOutputHandler.displayMethod(outputRecord.getKey() +"\n"+outputRecord.getValue()+"\n");
        }
    }
}
