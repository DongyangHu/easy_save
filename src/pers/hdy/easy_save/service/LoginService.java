package pers.hdy.easy_save.service;

import pers.hdy.easy_save.business.LoginBussiness;
import pers.hdy.easy_save.entity.User;

public class LoginService {
	public User login(String ID) {
		return LoginBussiness.login(ID);
	}
}
