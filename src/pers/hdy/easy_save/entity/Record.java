package pers.hdy.easy_save.entity;

public class Record {
	// 记录ID
	private String DataID;
	// 账户账号
	private String account;
	// 账户密码
	private String account_pw;
	// 账户类型
	private String account_type;
	// 创建时间
	private String createTime;
	// 属于哪一个用户
	private String userID;

	// get set方法

	public String getDataID() {
		return DataID;
	}

	public void setDataID(String dataID) {
		DataID = dataID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getAccount_pw() {
		return account_pw;
	}

	public void setAccount_pw(String account_pw) {
		this.account_pw = account_pw;
	}

	public String getAccount_type() {
		return account_type;
	}

	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	// 构造方法
	public Record() {
		
	}

}
