package pers.hdy.easy_save.business;

import java.sql.ResultSet;
import java.sql.SQLException;

import pers.hdy.easy_save.entity.User;
import pers.hdy.easy_save.util.BaseDao;

public class LoginBussiness {
	public static User login(String ID) {
		BaseDao basedao1 = new BaseDao();
		BaseDao basedao2 = new BaseDao();
		User user = null;
		basedao1.linkDB();
		basedao2.linkDB();
		ResultSet Rs_su = basedao1.queryData("user_su", "*", "ID='" + ID + "'");
		ResultSet Rs_gen = basedao2.queryData("user_gen", "*", "ID='" + ID + "'");
		try {
			if (Rs_su.next()) {
				user = new User();
				user.setID(Rs_su.getString(1));
				user.setName(Rs_su.getString(2));
				user.setPassword(Rs_su.getString(3));
				user.setFlag(Rs_su.getString(4));
				user.setNote(Rs_su.getString(5));
			}else if (Rs_gen.next()) {
				user = new User();
				user.setID(Rs_gen.getString(1));
				user.setName(Rs_gen.getString(2));
				user.setPassword(Rs_gen.getString(3));
				user.setFlag(Rs_gen.getString(4));
				user.setCreateDay(Rs_gen.getString(5));
				user.setNote(Rs_gen.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		basedao1.closeDB();
		basedao2.closeDB();
		return user;
	}
}
