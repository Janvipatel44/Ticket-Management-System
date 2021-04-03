package managerfeatures.abstractfactory;

import database.ConnectionManager;
import managerfeatures.interfaces.IManagerTeamTracking;

public interface IManagerFeaturesFactory {

	IManagerTeamTracking makeManagerFeaturesFactoryObject(ConnectionManager connectionManager);

}