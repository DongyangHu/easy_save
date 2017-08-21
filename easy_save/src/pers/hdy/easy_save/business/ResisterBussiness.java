package pers.hdy.easy_save.business;

import pers.hdy.easy_save.entity.User;
import pers.hdy.easy_save.util.BaseDao;
import pers.hdy.easy_save.util.GetTime;
import pers.hdy.easy_save.util.ProduceID;

public class ResisterBussiness {
	public static boolean register(User user) {
		BaseDao basedao = new BaseDao();
		basedao.linkDB();
		// 随机一个三位ID
		ProduceID pid = new ProduceID();
		user.setID(pid.getId());
		user.setFlag("generic");
		user.setCreateDay(GetTime.getTime());
		user.setNote("note");
		String insertString = "'" + user.getID() + "','" + user.getName() + "','" + user.getPassword() + "','"
				+ user.getFlag() + "','" + user.getCreateDay() + "','" + user.getNote() + "'";
		if(basedao.insertData("user_gen", insertString, "ID = '" + user.getID() + "'")){
			basedao.closeDB();
			return true;
		}else{
			return false;
		}
	}
}
