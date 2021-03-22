package attachment;

import java.util.UUID;

public abstract class AbstractAttachment implements IAttachment {
	
	public String generateAttachmentId() {
		return UUID.randomUUID().toString().replace("-", "");
	}
	
}
