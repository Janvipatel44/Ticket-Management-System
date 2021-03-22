package Rating;
import login.Interfaces.IParameterizedUser;
public class RatingAssignee implements IRatingAssignee
{
    IRatingQuestionnaire questionnaire;
    IPersistenceRating persistenceRating;

    public RatingAssignee(IRatingQuestionnaire questionnaire, IPersistenceRating persistenceRating)
    {
        this.questionnaire = questionnaire;
        this.persistenceRating = persistenceRating;
    }

    public boolean provideRating(IParameterizedUser user, String ticketID)
    {
        if(questionnaire.checkRatingQuestionnaire())
        {
            int finalRating = questionnaire.calculateRating();
            String creatorID = persistenceRating.getPersistenceCreatorID(ticketID);
            if(creatorID == null)
            {
                return false;
            }
            else if(creatorID == user.getEmployeeID())
            {
                persistenceRating.insertRating(ticketID, finalRating);
            }
            return false;
        }
        return false;
    }
}
