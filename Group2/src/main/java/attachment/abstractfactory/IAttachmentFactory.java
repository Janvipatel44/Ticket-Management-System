package attachment.abstractfactory;

import attachment.interfaces.IAttachment;

public interface IAttachmentFactory {

	IAttachment makeAttachmentObject(String attachmentType);

}