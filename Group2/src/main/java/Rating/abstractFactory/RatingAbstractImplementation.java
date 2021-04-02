package Rating.abstractFactory;
import Rating.*;
import Rating.interfaces.*;
public class RatingAbstractImplementation extends RatingFactory
{
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