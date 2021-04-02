package userinterface;
import Rating.abstractfactory.*;
import Rating.interfaces.*;
public class RatingScreen
{
    private final IInputOutputHandler inputOutputHandler;
    private final IRatingFactory ratingFactory;

    public RatingScreen(IInputOutputHandler inputOutputHandler)
    {
        this.inputOutputHandler = inputOutputHandler;
        ratingFactory = RatingFactory.instance();
    }

    public void displayRatingScreen(String employeeID)
    {
        String ticketID;
        int userSatisfactionRating;
        int userFeedbackRating;
        int userExperienceRating;
        int userRecommendationRating;
        IPersistenceRating persistenceRating;
        IRatingQuestionnaire ratingQuestionnaire;
        IRatingAssignee ratingAssignee;

        inputOutputHandler.displayMethod("Enter ticket ID to provide rating:\n");
        ticketID = inputOutputHandler.input();

        inputOutputHandler.displayMethod("Enter user satisfaction rating (Hint: values allowed -> 0-25)\n");
        userSatisfactionRating = inputOutputHandler.inputInt();

        inputOutputHandler.displayMethod("Enter user feedback rating (Hint: values allowed -> 0-25)\n");
        userFeedbackRating = inputOutputHandler.inputInt();

        inputOutputHandler.displayMethod("Enter user experience rating (Hint: values allowed -> 0-25)\n");
        userExperienceRating = inputOutputHandler.inputInt();

        inputOutputHandler.displayMethod("Enter user recommendation rating (Hint: values allowed -> 0-25)\n");
        userRecommendationRating = inputOutputHandler.inputInt();

        ratingQuestionnaire = ratingFactory.getRatingQuestionnaire(userSatisfactionRating, userFeedbackRating, userExperienceRating, userRecommendationRating);
        ratingAssignee = ratingFactory.getRatingAssignee(ratingQuestionnaire);

        if(ratingAssignee.provideRating(employeeID, ticketID))
        {
            inputOutputHandler.displayMethod("Rating has been provided successfully.\n");
        }
        else
        {
            inputOutputHandler.displayMethod("Rating was not provided to the given ticket. Please check the information and try again.\n");
        }
    }
}
