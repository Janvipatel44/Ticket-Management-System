package mailservice.abstractfactory;

import mailservice.interfaces.IMail;

public interface IMailFactory {

	IMail makeMailObject(String mailType);

}