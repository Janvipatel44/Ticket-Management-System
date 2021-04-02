package managerfeatures.abstractfactory;

import database.ConnectionManager;
import managerfeatures.ManagerFeaturesDao;
import managerfeatures.ManagerTeamTracking;
import managerfeatures.interfaces.IManagerTeamTracking;

public class ManagerFeaturesFactory implements IManagerFeaturesFactory {

	private static IManagerFeaturesFactory uniqueInstance = null;		
	
	private ManagerFeaturesFactory() {
	}

	public static IManagerFeaturesFactory instance() {
		if(null == uniqueInstance) {
			uniqueInstance = new ManagerFeaturesFactory();
		}
		return uniqueInstance;
	}
	
	@Override
	public IManagerTeamTracking makeManagerFeaturesFactoryObject(ConnectionManager connectionManager) {
		if(connectionManager == null) {
			return null;
		}
		ManagerFeaturesDao managerFeaturesDao = new ManagerFeaturesDao(connectionManager);
		return new ManagerTeamTracking(managerFeaturesDao);
	}
}
