package Rating;
import login.Interfaces.IParameterizedUser;
public interface IRatingAssignee
{
    public boolean provideRating(IParameterizedUser user, String ticketID);
}
