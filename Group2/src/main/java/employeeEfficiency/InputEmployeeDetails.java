package employeeEfficiency;

public class InputEmployeeDetails implements IInputEmployeeDetails
{
    private String employeeId = null;
    private String date = null;

    public String getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId= employeeId;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
