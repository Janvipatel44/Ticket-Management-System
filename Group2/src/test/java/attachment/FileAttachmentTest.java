package attachment;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import attachment.interfaces.IAttachment;
import attachment.interfaces.IAttachmentDao;

public class FileAttachmentTest {

	private final String NULL_OBJECT = null;
	private final String EMPTY = "";
	private final String SOURCE_PATH = "src/test/java/attachment/sourceFile.txt";
	private final String DESTINATION_PATH = "src/test/java/attachment/destinationFile.txt";
	
	private IAttachmentDao fileAttachmentDao;
	private IAttachment attachment;

	@Before
	public void init() {
		fileAttachmentDao = new FileAttachmentDaoMock();
		attachment = new FileAttachment(fileAttachmentDao);
	}
	
	@Test
	public void uploadNullTest() throws Exception {
		String attachmentId = attachment.upload(NULL_OBJECT);
		assertNull(attachmentId);
	}
	
	@Test
	public void uploadEmptyTest() throws Exception {
		String attachmentId = attachment.upload(EMPTY);
		assertNull(attachmentId);
	}
	
	@Test
	public void uploadTest() throws Exception {
		String attachmentId = attachment.upload(SOURCE_PATH);
		assertNotNull(attachmentId);
	}
	
	@Test
	public void downloadNullAttachmentTest() throws Exception {
		boolean result = attachment.download(NULL_OBJECT, DESTINATION_PATH);
		assertFalse(result);
	}
	
	@Test
	public void downloadEmptyAttachmentTest() throws Exception {
		boolean result = attachment.download(EMPTY, DESTINATION_PATH);
		assertFalse(result);
	}
	
	@Test
	public void downloadNullDestinationTest() throws Exception {
		String attachmentId = attachment.upload(SOURCE_PATH);
		boolean result = attachment.download(attachmentId, NULL_OBJECT);
		assertFalse(result);
	}
	
	@Test
	public void downloadEmptyDestinationTest() throws Exception {
		String attachmentId = attachment.upload(SOURCE_PATH);
		boolean result = attachment.download(attachmentId, EMPTY);
		assertFalse(result);
	}
	
	
	@Test
	public void downloadTest() throws Exception {
		String attachmentId = attachment.upload(SOURCE_PATH);
		boolean result = attachment.download(attachmentId, DESTINATION_PATH);
		assertTrue(result);
	}
}
