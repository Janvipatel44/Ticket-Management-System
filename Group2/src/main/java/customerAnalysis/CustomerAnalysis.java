package customerAnalysis;
import customerAnalysis.Interfaces.IComputeCustomerProperties;
import customerAnalysis.Interfaces.ICustomerAnalysis;
import customerAnalysis.Interfaces.IParameterizedCustomerTicket;
import customerAnalysis.Interfaces.IPersistenceCustomer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CustomerAnalysis implements ICustomerAnalysis
{
    IPersistenceCustomer persistenceCustomer = new PersistenceCustomer();
    List<IParameterizedCustomerTicket> tickets;
    IComputeCustomerProperties computeCustomerProperties;

    public String getCustomerAnalysis(String customerID)
    {
        String customerAnalysis = customerID + "\n";
        String failureResult = "No data found for "+ customerID;
        tickets = persistenceCustomer.getTicketsOfCustomer(customerID);
        Map<String, Integer> assigneeStatistics = new HashMap<>();
        String ticketRating[] = {"Good", "Bad"};
        float ratingThreshold = 3.5f;

        if(tickets.size() == 0 || tickets == null)
        {
            return failureResult;
        }
        computeCustomerProperties = new ComputeCustomerProperties(customerID, tickets);
        customerAnalysis = customerAnalysis.concat("Average tickets priority : "+computeCustomerProperties.getMeanPriority()+"\n");
        customerAnalysis = customerAnalysis.concat("Average tickets urgency : "+computeCustomerProperties.getMeanUrgency()+"\n");
        customerAnalysis = customerAnalysis.concat("Average tickets impact : "+computeCustomerProperties.getMeanImpact()+"\n");
        customerAnalysis = customerAnalysis.concat("Most tickets of type : "+computeCustomerProperties.getModeTicketType()+"\n");
        customerAnalysis = customerAnalysis.concat("Most tickets created by : "+computeCustomerProperties.getModeCreator()+"\n");
        customerAnalysis = customerAnalysis.concat("Most tickets of level : "+computeCustomerProperties.getModeTicketLevel()+"\n");
        customerAnalysis = customerAnalysis.concat("Average tickets priority : "+computeCustomerProperties.getMeanPriority()+"\n");
        customerAnalysis = customerAnalysis.concat("Average respinse time (in days) : "+computeCustomerProperties.getAverageResolutionDays()+"\n");
        customerAnalysis = customerAnalysis.concat("Tickets assignee statistics : \n");
        assigneeStatistics = computeCustomerProperties.getCustomerTicketAssigneeStatistics();

        if(assigneeStatistics.isEmpty())
        {
            customerAnalysis = customerAnalysis.concat("No assignee details found.\n");
        }
        else
        {
            for(Map.Entry<String, Integer> assigneeStats : assigneeStatistics.entrySet())
            {
                int value = assigneeStats.getValue();
                String valueString = Integer.toString(value);
                customerAnalysis = customerAnalysis.concat("\t"+assigneeStats.getKey()+" : "+valueString+"\n");
            }
        }

        if(computeCustomerProperties.getMeanRating() >= ratingThreshold)
        {
            customerAnalysis = customerAnalysis.concat("Overall user rating : "+ticketRating[0]+"\n");
        }
        else
        {
            customerAnalysis = customerAnalysis.concat("Overall user rating : "+ticketRating[1]+"\n");
        }

        return customerAnalysis;
    }
}
