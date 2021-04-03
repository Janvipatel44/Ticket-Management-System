package attachment.abstractfactory;

import attachment.interfaces.IAttachment;
import database.ConnectionManager;

public interface IAttachmentFactory {

	IAttachment makeAttachmentObject(String attachmentType, ConnectionManager connectionManager);

}