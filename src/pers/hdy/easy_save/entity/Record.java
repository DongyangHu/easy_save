package pers.hdy.easy_save.entity;

public class Record {
	// ��¼ID
	private String DataID;
	// �˻��˺�
	private String account;
	// �˻�����
	private String account_pw;
	// �˻�����
	private String account_type;
	// ����ʱ��
	private String createTime;
	// ������һ���û�
	private String userID;

	// get set����

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

	// ���췽��
	public Record() {
		
	}

}
