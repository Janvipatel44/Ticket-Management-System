package employeeEfficiency;

import com.mysql.cj.protocol.Resultset;

public interface IGenerateEfficiencyReport 
{
	public boolean displayEmployeeDetails(Resultset resultSet);
}
