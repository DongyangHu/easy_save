package pers.hdy.easy_save.service;

import pers.hdy.easy_save.entity.User;
import pers.hdy.easy_save.business.ResisterBussiness;

public class RegisterService {
	
	public boolean register (User user){
		return ResisterBussiness.register(user);
	}
}
