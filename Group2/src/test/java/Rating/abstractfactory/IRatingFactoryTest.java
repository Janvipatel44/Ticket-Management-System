package Rating.abstractfactory;
import Rating.interfaces.IPersistenceRating;
import Rating.interfaces.IRatingAssignee;
import Rating.interfaces.IRatingQuestionnaire;
public interface IRatingFactoryTest
{
    IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire);
    IPersistenceRating getPersistenceRatingMock();
    IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating);
}
