package attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.UUID;

import org.apache.commons.io.FileUtils;

public class FileAttachment implements IAttachment {

	private IFileAttachmentDao fileAttachmentDao = null;

	public FileAttachment(IFileAttachmentDao fileAttachmentDao) {
		this.fileAttachmentDao = fileAttachmentDao;
	}

	public String upload(String sourcePath) throws Exception {
		String attachmentId = UUID.randomUUID().toString().replace("-", "");
		try {
			File file = new File(sourcePath);
			InputStream fileInputStream = new FileInputStream(file);
			fileAttachmentDao.uploadFileAttachment(attachmentId, fileInputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File is not present at the specified path");
		}
		return attachmentId.toString();
	}

	public void download(String attachmentId, String destinationPath) throws Exception{
		File outputFile = new File(destinationPath);
		InputStream dbStoredFile = fileAttachmentDao.downloadFileAttachment(attachmentId);
		FileUtils.copyInputStreamToFile(dbStoredFile, outputFile);
	}
}
