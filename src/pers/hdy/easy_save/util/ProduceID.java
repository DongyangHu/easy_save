package pers.hdy.easy_save.util;

import java.sql.SQLException;


/**
 * 生产不重复的3位用户ID
 * @author HuDongyang
 *
 */
public class ProduceID {

	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	// 构造方法
	public ProduceID() {
		do {
			this.id = productID();
		} while (!notExist(this.id));
	}

	// 产生随机三位数的字符串
	public String productID() {
		String temp1 = (int) (Math.random() * 10) + "";
		String temp2 = (int) (Math.random() * 10) + "";
		String temp3 = (int) (Math.random() * 10) + "";
		return temp1 + temp2 + temp3;
	}

	// 判断ID是否不存在
	public boolean notExist(String tempid) {
		BaseDao basedao = new BaseDao();
		basedao.linkDB();
		basedao.queryData("user_gen", "*", "ID = '" + tempid + "'");
		try {
			if (basedao.rs.next()) {
				basedao.closeDB();
				return false;
			} else {
				basedao.closeDB();
				return true;
			}
		} catch (SQLException e) {
			basedao.closeDB();
			return false;
		}
	}
}
