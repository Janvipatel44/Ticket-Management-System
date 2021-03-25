package attachment;

public interface IAttachment {
	
	public String upload(String sourcePath) throws Exception;

	public boolean download(String attachmentId, String destinationPath) throws Exception;
}
