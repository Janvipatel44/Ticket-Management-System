package mailservice;

public class FactoryMethodMail {
	
	public final String GMAIL = "gmail";
	
	public IMail getMailObject(String mailType) {
		
		if (mailType == null) {
			return null;
		}
		
		if (mailType.equalsIgnoreCase(GMAIL)) {
			return new Gmail();
		} 
		
		return null;
	}
}
