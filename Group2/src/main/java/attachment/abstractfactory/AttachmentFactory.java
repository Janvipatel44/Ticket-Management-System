package attachment.abstractfactory;

import attachment.FileAttachment;
import attachment.FileAttachmentDao;
import attachment.interfaces.IAttachment;
import attachment.interfaces.IAttachmentDao;
import database.ConnectionManager;

public class AttachmentFactory implements IAttachmentFactory {
	
	public final String FILE_ATTACHMENT = "File";
	
	private static IAttachmentFactory uniqueInstance = null;
	
	private AttachmentFactory() {

	}

	public static IAttachmentFactory instance() {
		if(null == uniqueInstance) {
			uniqueInstance = new AttachmentFactory();
		}
		return uniqueInstance;
	}
	
	@Override
	public IAttachment makeAttachmentObject(String attachmentType, ConnectionManager connectionManager) {
		
		if (attachmentType == null || connectionManager == null) {
			return null;
		}
		
		if (attachmentType.equalsIgnoreCase(FILE_ATTACHMENT)) {
			IAttachmentDao attachmentDao = new FileAttachmentDao(connectionManager);
			return new FileAttachment(attachmentDao);
		} 
		
		return null;
	}
}
