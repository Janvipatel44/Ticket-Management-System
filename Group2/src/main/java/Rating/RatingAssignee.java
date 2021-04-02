package Rating;
import Rating.abstractfactory.*;
import Rating.interfaces.*;
public class RatingAssignee implements IRatingAssignee
{
    IRatingFactory ratingFactory = RatingFactory.instance();
    IRatingQuestionnaire questionnaire;
    IPersistenceRating persistenceRating = ratingFactory.getPersistenceRating();

    public RatingAssignee(IRatingQuestionnaire questionnaire)
    {
        this.questionnaire = questionnaire;
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