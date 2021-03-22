package login;
public class ParameterizedUser {

	private String employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String user_type;
	
	ParameterizedUser(String employeeID, String firstName, String lastName, String email, String user_type)
	{
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.user_type = user_type;
	}
	
	public String getEmployeeID()
	{
		return employeeID;
	}
	
	public String getfirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public String getEmail()
	{
		return email;
	}

	public String getUserType()
	{
		return user_type;
	}
}