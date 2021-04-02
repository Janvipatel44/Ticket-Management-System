package Rating.abstractfactory;
import Rating.*;
import Rating.interfaces.*;
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

    public IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire)
    {
        return new RatingAssignee(questionnaire);
    }

    public IPersistenceRating getPersistenceRating()
    {
        return new PersistenceRating();
    }

    public IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating)
    {
        return new RatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
    }
}