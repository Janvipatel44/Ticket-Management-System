package attachment;

import java.io.InputStream;

import validations.StringValidations;

public class FileAttachmentDaoMock implements IFileAttachmentDao {

	private InputStream inputStream;
	private String attachmentId;

	@Override
	public boolean uploadFileAttachment(String attachmentId, InputStream inputStream) throws Exception {
		this.attachmentId = attachmentId;
		this.inputStream = inputStream;
		return true;
	}

	@Override
	public InputStream downloadFileAttachment(String attachmentId) throws Exception {
		if(StringValidations.isStringValid(attachmentId) && attachmentId.trim().equalsIgnoreCase(this.attachmentId)) {
			return this.inputStream;
		}
		return null;
	}

}
