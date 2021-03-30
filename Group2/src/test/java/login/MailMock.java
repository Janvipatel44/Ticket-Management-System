package login;
import mailservice.IMail;
import mailservice.IMailMessage;
public class MailMock implements IMail
{

    public boolean sendMail(String mailConfiguration, String userConfiguration, IMailMessage message) throws Exception
    {
        return true;
    }
}
