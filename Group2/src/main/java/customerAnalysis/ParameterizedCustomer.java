package customerAnalysis;
public class ParameterizedCustomer
{
    String customerName;
    String customerID;
    String address;
    String contact;


    ParameterizedCustomer(String customerID, String customerName, String address, String contact)
    {
        this.customerID = customerID;
        this.customerName = customerName;
        this.address = address;
        this.contact = contact;
    }
}
