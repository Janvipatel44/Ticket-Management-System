package attachment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;

public class FileAttachment extends AbstractAttachment {

	private IFileAttachmentDao fileAttachmentDao = null;

	public FileAttachment(IFileAttachmentDao fileAttachmentDao) {
		this.fileAttachmentDao = fileAttachmentDao;
	}

	public String upload(String sourcePath) throws Exception {
		String attachmentId = generateAttachmentId();
		try {
			File file = new File(sourcePath);
			InputStream fileInputStream = new FileInputStream(file);
			fileAttachmentDao.uploadFileAttachment(attachmentId, fileInputStream);
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File is not present at the specified path");
		}
		return attachmentId.toString();
	}

	public boolean download(String attachmentId, String destinationPath) throws Exception{
		boolean downloadedSuccessfully = true;
		try {
		File outputFile = new File(destinationPath);
		InputStream dbStoredFile = fileAttachmentDao.downloadFileAttachment(attachmentId);
		FileUtils.copyInputStreamToFile(dbStoredFile, outputFile);
		} catch (IOException e) {
			throw new IllegalArgumentException("Please check destination path.");
		}
		return downloadedSuccessfully;
	}
}
