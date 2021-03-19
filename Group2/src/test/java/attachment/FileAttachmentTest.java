package attachment;

import org.junit.Before;

public class FileAttachmentTest {

	private IFileAttachmentDao fileAttachmentDao;
	private IAttachment attachment;

	@Before
	public void init() {
		fileAttachmentDao = null;
		attachment = new FileAttachment(fileAttachmentDao);
	}
}
