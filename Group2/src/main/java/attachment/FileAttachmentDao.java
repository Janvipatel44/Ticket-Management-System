package attachment;

import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.cj.jdbc.Blob;

import attachment.interfaces.IAttachmentDao;
import database.IConnectionManager;
import database.abstractfactory.DatabaseFactory;
import database.abstractfactory.IDatabaseFactory;
import mailservice.ReadPropertiesFile;

public class FileAttachmentDao implements IAttachmentDao {

	private final IDatabaseFactory databaseFactory = DatabaseFactory.instance();
	private final String uploadAttachment = "upload_attachment";
	private final String downloadAttachment = "download_attachment";
	private IConnectionManager connectionManager;
	private String projectConfigurationFile = "ProjectConfiguration.properties";
	private String dbConfigurationKey = "DBConfiguration";

	public FileAttachmentDao() throws IOException {
		Properties properties = ReadPropertiesFile.readConfigPropertyFile(projectConfigurationFile);
		String configurationFile = (String)properties.get(dbConfigurationKey);
		connectionManager = databaseFactory.getConnectionManager(configurationFile);
	}
	
	@Override
	public boolean uploadFileAttachment(String attachmentId, InputStream inputStream) throws Exception{
		
		if(connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");	
		}
		
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		try {
			procedureCall = connection.prepareCall("call " + uploadAttachment + "(?,?)");
			procedureCall.setString(1, attachmentId);
			procedureCall.setBlob(2, inputStream);

			int updatedRows = procedureCall.executeUpdate();

			if (updatedRows > 0) {
				return true;
			}
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
		return false;
	}
	
	@Override
	public InputStream downloadFileAttachment(String attachmentId) throws Exception {
		
		if(connectionManager == null) {
			throw new Exception("Error while creating connection to DB. Please contact admin.");	
		}
		
		InputStream inputStream = null;
		Connection connection = connectionManager.establishConnection();
		CallableStatement procedureCall;
		try {
			procedureCall = connection.prepareCall("call " + downloadAttachment + "(?)");
			procedureCall.setString(1, attachmentId);

			boolean isResultSet = procedureCall.execute();

			if (isResultSet) {
				ResultSet resultSet = procedureCall.getResultSet();
				if (resultSet.next()) {
					inputStream = ((Blob) resultSet.getBlob(1)).getBinaryStream();
				}
			}
		} catch (SQLException throwables) {
			throw new Exception("Failed during DB operations. Please contact admin.");
		}
		return inputStream;
	}

}
