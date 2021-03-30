package Rating.abstractFactory;
import Rating.*;
import Rating.interfaces.*;
public abstract class RatingFactory
{
    public abstract IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire);
    public abstract IPersistenceRating getPersistenceRating();
    public abstract IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating);
}
