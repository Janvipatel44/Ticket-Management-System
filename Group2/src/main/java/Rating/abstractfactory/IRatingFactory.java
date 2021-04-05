package Rating.abstractfactory;
import Rating.interfaces.*;

import java.io.IOException;

public interface IRatingFactory
{
    IRatingAssignee getRatingAssignee(IRatingQuestionnaire questionnaire) throws IOException;
    IPersistenceRating getPersistenceRating() throws IOException;
    IRatingQuestionnaire getRatingQuestionnaire(int userSatisfactionRating, int userFeedbackRating, int userExperienceRating, int userRecommendationRating);
}
