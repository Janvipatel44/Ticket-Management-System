package mailservice;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import mailservice.abstractfactory.IMailFactory;
import mailservice.abstractfactory.MailFactory;
import mailservice.interfaces.IMail;
import mailservice.interfaces.IMailMessage;

public class GmailTest {

	private final IMailMessage MAIL_MESSAGE_NULL_OBJECT = null;
	private final String NULL_OBJECT = null;
	private final String EMPTY = "";
	private final String INVALID_PATH = "invalidpath.txt";
	private final String MAIL_CONFIGURATION = "MailConfiguration.properties";
	private final String USER_CONFIGURATION = "MailUserConfiguration.properties";
	private final String RECIPIENT = "csci5308gp2@gmail.com";
	private final String SUBJECT = "TEST";
	private final String BODY = "Testing MailMessage class";
	private final String MAIL_TYPE = "gmail";

	private IMail gmail;
	private IMailMessage mailMessage;

	@Before
	public void init() {
		IMailFactory mailFactory = MailFactory.instance();
		gmail = mailFactory.makeMailObject(MAIL_TYPE);
		mailMessage = mailFactory.makeMailMessageObject();
		mailMessage.addRecipient(RECIPIENT);
		mailMessage.addSubject(SUBJECT);
		mailMessage.addBody(BODY);
	}

	@Test
	public void sendMailNullMailConfigurationTest() throws Exception {
		boolean isMailSent = gmail.sendMail(NULL_OBJECT, USER_CONFIGURATION, mailMessage);
		assertFalse(isMailSent);
	}

	@Test
	public void sendMailEmptyMailConfigurationTest() throws Exception {
		boolean isMailSent = gmail.sendMail(EMPTY, USER_CONFIGURATION, mailMessage);
		assertFalse(isMailSent);
	}

	@Test
	public void sendMailNullUserConfigurationTest() throws Exception {
		boolean isMailSent = gmail.sendMail(MAIL_CONFIGURATION, NULL_OBJECT, mailMessage);
		assertFalse(isMailSent);
	}

	@Test
	public void sendMailEmptyUserConfigurationTest() throws Exception {
		boolean isMailSent = gmail.sendMail(MAIL_CONFIGURATION, EMPTY, mailMessage);
		assertFalse(isMailSent);
	}

	@Test
	public void sendMailNullMessageTest() throws Exception {
		boolean isMailSent = gmail.sendMail(MAIL_CONFIGURATION, USER_CONFIGURATION, MAIL_MESSAGE_NULL_OBJECT);
		assertFalse(isMailSent);
	}

	@Test(expected = Exception.class)
	public void sendMailInvalidMailConfigurationTest() throws Exception {
		gmail.sendMail(INVALID_PATH, USER_CONFIGURATION, mailMessage);
	}

	@Test(expected = Exception.class)
	public void sendMailInvalidUserConfigurationTest() throws Exception {
		gmail.sendMail(MAIL_CONFIGURATION, INVALID_PATH, mailMessage);
	}

	@Test(expected = Exception.class)
	public void sendMailTest() throws Exception {
		boolean isMailSent = gmail.sendMail(MAIL_CONFIGURATION, USER_CONFIGURATION, mailMessage);
		assertTrue(isMailSent);
	}
}
