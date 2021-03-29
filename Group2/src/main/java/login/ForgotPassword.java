package login;
import login.Interfaces.IForgotPassword;
import login.Interfaces.IPasswordValidations;
import login.Interfaces.IPersistenceForgotPasswordOperations;
import mailservice.FactoryMethodMail;
import mailservice.IMail;
import mailservice.IMailMessage;
import mailservice.MailMessage;
public class ForgotPassword implements IForgotPassword
{
    private int otp;
    private String employeeID;
    private final FactoryMethodMail factoryMethodMail = new FactoryMethodMail();
    private final IMail mail;
    private final IMailMessage mailMessage = new MailMessage();
    private final IPersistenceForgotPasswordOperations persistenceForgotPasswordOperations;

    public ForgotPassword(IMail mail, IPersistenceForgotPasswordOperations persistenceForgotPasswordOperations)
    {
        this.mail = mail;
        this.persistenceForgotPasswordOperations = persistenceForgotPasswordOperations;
    }
    public boolean sendOTP(String employeeID)
    {
        final String mailConfiguration = "MailConfiguration.properties";
        final String userConfiguration = "MailUserConfiguration.properties";
        this.employeeID = employeeID;
        String email;
        String subject;
        String message;
        int minimum = 1000;
        otp = (int)Math.random();

        if(otp == 0)
        {
            otp = minimum;
        }
        else
        {
            otp = otp * minimum;
        }

        email = persistenceForgotPasswordOperations.getEmail(employeeID);
        subject = "Mock Service Now: OTP Request";
        message = "Hello,\nThe OTP to update password is : "+otp+"\nThanks & Regards,\nMock Service Now Team";

        mailMessage.addRecipient(email);
        mailMessage.addSubject(subject);
        mailMessage.addBody(message);

        try
        {
            return mail.sendMail(mailConfiguration, userConfiguration, mailMessage);
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public boolean updatePassword(int otp, String newPassword)
    {
        IPasswordValidations passwordValidations = new PasswordValidations();
        if( passwordValidations.checkUpperCaseRule(newPassword) &&
            passwordValidations.checkLowerCaseRule(newPassword) &&
            passwordValidations.checkNumberRule(newPassword) &&
            passwordValidations.checkSpecialCharacterRule(newPassword) &&
            passwordValidations.checkLengthRule(newPassword) &&
            this.otp == otp)
        {
            return persistenceForgotPasswordOperations.updatePassword(this.employeeID, newPassword);
        }
        return false;
    }
}
