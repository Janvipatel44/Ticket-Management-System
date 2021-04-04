package employeeEfficiency;

import employeeEfficiency.Interfaces.IInputEmployeeDetails;

public class InputEmployeeDetails implements IInputEmployeeDetails
{
    private String employeeId = null;
    private String date = null;

    public InputEmployeeDetails(String date, String employeeId){
    	this.date = date;
    	this.employeeId = employeeId;
    }
    public String getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }
    
}
