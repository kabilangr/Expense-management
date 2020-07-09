package Service;

import Model.Admin;
import Model.User;

public class Validation extends UserValidation implements AdminValidation
{
	public boolean nameValidation(Admin admin)
	{
		if((admin.getAdminName()).equals(admin.getAdminNameCheck()))
				return true;
		return false;
	}
	public boolean passwordValidation(Admin admin)
	{
		if((admin.getAdminPassword()).equals(admin.getAdminPassCheck()))
			return true;
		return false;
	}
	public boolean nameValidation(User user) {
		
		if((user.getUserName()).equals(user.getUserNameCheck()))
			return true;
		return false;
	}
	public boolean passwordValidation(User user) {
		if((user.getUserPassword().equals(user.getUserPassCheck())))
			return true;
		return false;
	}
}
