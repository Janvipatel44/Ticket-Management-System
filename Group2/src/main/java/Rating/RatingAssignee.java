package Rating;
import Rating.interfaces.*;
public class RatingAssignee implements IRatingAssignee
{
    IRatingQuestionnaire questionnaire;
    IPersistenceRating persistenceRating;

    public RatingAssignee(IRatingQuestionnaire questionnaire, IPersistenceRating persistenceRating)
    {
        this.questionnaire = questionnaire;
        this.persistenceRating = persistenceRating;
    }

    public boolean provideRating(String employeeID, String ticketID)
    {
        if(questionnaire.checkRatingQuestionnaire())
        {
            int finalRating = questionnaire.calculateRating();
            String creatorID = persistenceRating.getPersistenceCreatorID(ticketID);
            if(creatorID == null)
            {
                return false;
            }
            else if(creatorID.equalsIgnoreCase(employeeID))
            {
                persistenceRating.insertRating(ticketID, finalRating);
            }
            return true;
        }
        return false;
    }
}