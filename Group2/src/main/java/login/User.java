package login;
public class User {

	private String employeeID;
	private String firstName;
	private String lastName;
	private String email;
	private String user_type;
	
	User(String employeeID, String firstName, String lastName, String email, String user_type)
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
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	public String getUserType()
	{
		return user_type;
	}
	
	public void setUserType(String user_type)
	{
		this.user_type = user_type;
	}
}