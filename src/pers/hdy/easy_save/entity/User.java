package pers.hdy.easy_save.entity;


public class User {
	// 用户ID
	private String ID;
	// 用户名
	private String name;
	//用户密码
	private String password;
	// 用户标识
	private String flag;
	// 该用户创建的日期
	private String createDay;
	// 用户预留信息
	private String note;

	// get,set方法
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getCreateDay() {
		return createDay;
	}

	public void setCreateDay(String createDay) {
		this.createDay = createDay;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
