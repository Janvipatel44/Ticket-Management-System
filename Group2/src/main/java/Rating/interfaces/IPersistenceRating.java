package Rating.interfaces;
public interface IPersistenceRating
{
    public String getPersistenceCreatorID(String ticketID);
    public boolean insertRating(String ticketID, int rating);
}
