package Rating;
import Rating.interfaces.IPersistenceRating;
public class PersistenceRatingMock implements IPersistenceRating
{
    public String getPersistenceCreatorID(String ticketID)
    {
        String creatorID = "USER123";
        return creatorID;
    }

    public boolean insertRating(String ticketID, int rating)
    {
        return true;
    }
}
