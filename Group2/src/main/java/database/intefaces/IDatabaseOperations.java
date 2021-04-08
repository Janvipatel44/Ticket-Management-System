package database.intefaces;
import java.sql.CallableStatement;
import java.sql.ResultSet;
public interface IDatabaseOperations
{
    boolean executeCommand(CallableStatement procedureCall);
    boolean executeUpdateCommand(CallableStatement procedureCall);
    ResultSet executeQuery(CallableStatement procedureCall);
}
