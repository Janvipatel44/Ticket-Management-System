package database.abstractfactory;

import insertTicket.Interfaces.ICreateTicket;
import insertTicket.Interfaces.ITicketOperationsDB;
import database.IConnectionManager;
import database.IDatabaseOperations;

public interface IDatabaseFactory {
    IConnectionManager getConnectionManager(String configurationFile);

    IDatabaseOperations getDatabaseOperations();

    ITicketOperationsDB getTicketOperationsDB(ICreateTicket createTicket);
}
