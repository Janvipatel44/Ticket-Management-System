package Rating;
public interface IRatingQuestionnaire
{
    int getUserSatisfactionRating();
    int getUserFeedbackRating();
    int getUserExperienceRating();
    int getUserRecommendationRating();
    boolean checkRatingQuestionnaire();
    int calculateRating();
}
