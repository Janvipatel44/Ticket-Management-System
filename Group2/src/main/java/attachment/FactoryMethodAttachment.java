package attachment;

import database.ConnectionManager;

public class FactoryMethodAttachment {
	
	public final String FILE_ATTACHMENT = "File";
	
	public IAttachment getAttachmentObject(String attachmentType, ConnectionManager connectionManager) {
		
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
