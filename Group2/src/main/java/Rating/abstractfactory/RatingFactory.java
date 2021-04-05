package Rating.abstractfactory;
import Rating.*;
import Rating.interfaces.*;

import java.io.IOException;

public class RatingFactory implements IRatingFactory
{
    private static IRatingFactory uniqueInstance = null;

    private RatingFactory()
    {

    }

    public static IRatingFactory instance()
    {
        if(null == uniqueInstance)
        {
            uniqueInstance = new RatingFactory();
        }
        return uniqueInstance;
    }

    public IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire) throws IOException
    {
        IPersistenceRating persistenceRating = getPersistenceRating();
        return new RatingAssigneeFacade(questionnaire, persistenceRating);
    }

    public IPersistenceRating getPersistenceRating() throws IOException
    {
        return new PersistenceRating();
    }

    public IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating)
    {
        return new RatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
    }
}