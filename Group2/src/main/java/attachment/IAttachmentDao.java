package attachment;

import java.io.InputStream;

public interface IAttachmentDao {
	
	public boolean uploadFileAttachment(String attachmentId, InputStream inputStream) throws Exception;

	public InputStream downloadFileAttachment(String attachmentId) throws Exception;
}
