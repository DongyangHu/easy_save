package pers.hdy.easy_save.entity;


public class User {
	// �û�ID
	private String ID;
	// �û���
	private String name;
	//�û�����
	private String password;
	// �û���ʶ
	private String flag;
	// ���û�����������
	private String createDay;
	// �û�Ԥ����Ϣ
	private String note;

	// get,set����
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
