package Rating;
import org.junit.Test;
import Rating.abstractFactory.RatingAbstractImplementation;
import Rating.abstractFactory.RatingFactory;
import static org.junit.Assert.*;
import Rating.interfaces.*;
public class RatingQuestionnaireTest
{
    RatingFactory ratingFactory = new RatingAbstractImplementation();

    @Test
    public void checkRatingQuestionnaireSuccessfulTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(20,18,2,3);
        assertTrue("Successful condition to check rating questionnaire failed.", questionnaire.checkRatingQuestionnaire());
    }

    @Test
    public void checkRatingQuestionnaireUnsuccessfulSatisfactionTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(100,18,2,3);
        assertFalse("Error condition of satisfaction in order to check rating questionnaire failed.", questionnaire.checkRatingQuestionnaire());
    }

    @Test
    public void checkRatingQuestionnaireUnsuccessfulFeedbackTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(20,180,2,3);
        assertFalse("Error condition of feedback in order to check rating questionnaire failed.", questionnaire.checkRatingQuestionnaire());
    }

    @Test
    public void checkRatingQuestionnaireUnsuccessfulExperienceTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(20,18,-2,3);
        assertFalse("Error condition of experience in order to check rating questionnaire failed.", questionnaire.checkRatingQuestionnaire());
    }

    @Test
    public void checkRatingQuestionnaireUnsuccessfulRecommendationTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(20,18,2,-3);
        assertFalse("Error condition of recommendation in order to check rating questionnaire failed.", questionnaire.checkRatingQuestionnaire());
    }

    @Test
    public void calculateRatingTest()
    {
        IRatingQuestionnaire questionnaire = ratingFactory.getRatingQuestionnaire(21,15,15,20);
        assertEquals("Calculate rating test failed.", 17, questionnaire.calculateRating());
    }
}