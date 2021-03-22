package database;

import java.sql.CallableStatement;

public interface IDatabaseOperations
{
    boolean executeCommand(CallableStatement procedureCall);
    boolean executeUpdateCommand(CallableStatement procedureCall);

}
