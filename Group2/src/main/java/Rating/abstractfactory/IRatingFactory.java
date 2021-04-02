package Rating.abstractfactory;
import Rating.interfaces.*;
public interface IRatingFactory
{
    IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire);
    IPersistenceRating getPersistenceRating();
    IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating);
}
