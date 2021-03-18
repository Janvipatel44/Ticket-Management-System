package main;

import attachment.FileAttachment;
import attachment.FileAttachmentDao;
import attachment.IAttachment;
import attachment.IFileAttachmentDao;
import database.ConnectionManager;
import database.IConnectionManager;

public class main {

	public static void main(String[] args) throws Exception {
		try {
			String path = "C:\\Dal\\CSCI 5308\\Important Links.txt";
			IConnectionManager connectionManager = new ConnectionManager("ConfigurationFile.txt");
			IFileAttachmentDao fileAttachmentDao = new FileAttachmentDao(connectionManager);
			IAttachment attachment = new FileAttachment(fileAttachmentDao);
//			attachment.upload(path);
			attachment.download("8d3193e7486a49f0b27128ac84f29a74", path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}