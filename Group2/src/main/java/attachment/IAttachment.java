package attachment;

public interface IAttachment {
	
	public String upload(String sourcePath) throws Exception;

	public void download(String attachmentId, String destinationPath) throws Exception;
}
