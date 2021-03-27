package employeeMilestones;
import employeeMilestones.abstractFactory.EmployeeMilestoneFactory;
import employeeMilestones.abstractFactory.EmployeeMilestoneFactoryImplementation;
import employeeMilestones.interfaces.IEmployeeMilestone;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.*;
public class EmployeeMilestoneTest
{
    @Test
    public void getEmployeeMilestoneTest()
    {
        EmployeeMilestoneFactory employeeMilestoneFactory = new EmployeeMilestoneFactoryImplementation();
        IEmployeeMilestone employeeMilestone = employeeMilestoneFactory.getEmployeeMilestone();
        Map<String, String> expectedResult = new HashMap<>();
        Map<String, String> actualResult = employeeMilestone.getEmployeeMilestone("EMP_123");

        expectedResult.put("Total tickets worked on : ", "3");
        expectedResult.put("Highest attention tickets worked on : ", "1");
        expectedResult.put("Different customers worked with : \n", "Bug\nUser education\n");
        expectedResult.put("Average resolution time (in hours) : ", "101.0");
        expectedResult.put("Overall tickets rating : ", "Good");
        expectedResult.put("Most ticket types worked on : ", "Bug");

        assertTrue("Employee milestone failed.", expectedResult.equals(actualResult));

    }

}