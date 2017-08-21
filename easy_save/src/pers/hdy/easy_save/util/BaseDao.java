package pers.hdy.easy_save.util;

import java.sql.*;
/**
 * ����easy_save���ݿ⣬�Լ������ݿ����ɾ�Ĳ����
 * @author HuDongyang
 *
 */
public class BaseDao {
	
	//����·��
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	//���ݿ��ַ
	private String DBURL = "jdbc:mysql://localhost:3306/easy_save?characterEncoding=utf8";
	//���ݿ��¼�û���
	private static final String DBUSER = "root";
	//���ݿ��û�����
	private static final String DBPASSWORD = "123456";
	
	/***********************************************************************************************/
	//���ݿ�����
	public Connection conn = null;
	//ִ��SQL���Ľӿ�
	public Statement stmt = null;
	//Ҫִ�е�SQL���
	public String SQLStr = null;
	//��������
	public ResultSet rs = null;
	//��ʾ��Ϣ
	public String TempInfo = "";
	
	
	//���췽��
	public BaseDao() {
		
	}
	
	
	/**
	 * �������ݿ�
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean linkDB(){
		try {
			Class.forName(DBDRIVER);
			conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
			stmt = conn.createStatement();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			try {
				stmt.close();
				conn.close();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			return false;
		}
	}
	
	/**
	 * �ر����ݿ�����
	 * @return �ɹ�����true��ʧ�ܷ���false
	 */
	public boolean closeDB(){
		try {
			stmt.close();
			conn.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	

	/**
	 * �������
	 * @param TableName Ҫ���������ݿ����
	 * @param InsertValue Ҫ���ӵ�����
	 * @param WhereStr ��ѯ�����Ƿ��Ѵ���Ҫ��������Ϣ
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean insertData(String TableName, String InsertValue, String WhereStr){
		this.SQLStr = "insert into " + TableName + " values (" + InsertValue + ")";
		try {
			if(stmt.executeQuery("select * from " + TableName + " where " + WhereStr).next()){
				TempInfo = "�ü�¼�Ѵ���!";
				this.closeDB();
				return false;
			}else{
				stmt.executeUpdate(SQLStr);
				this.closeDB();
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.closeDB();
			return false;
		}
		
	}
	
	/**
	 * ɾ������
	 * @param TableName Ҫ���������ݿ����
	 * @param WhereStr ɾ����һ����¼
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean deleteData(String TableName, String WhereStr){
		this.SQLStr = "delete from " + TableName + " where " + WhereStr;
		try {
			if(stmt.executeUpdate(SQLStr) != 0){
				this.closeDB();
				return true;
			}else{
				this.closeDB();
				TempInfo = "���ݲ�����!";
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			this.closeDB();
			return false;
		}
	}
	
	/**
	 * �޸�����
	 * @param TableName  Ҫ���������ݿ����
	 * @param UpdateValue  Ҫ�޸ĵ�����
	 * @param WhereStr Ҫ�޸���һ����¼
	 * @return �ɹ�����true,ʧ�ܷ���false
	 */
	public boolean updateData (String TableName, String UpdateValue, String WhereStr){
		this.SQLStr = "update " + TableName + " set " + UpdateValue + " where " + WhereStr;
		try {
			if(stmt.executeUpdate(SQLStr) != 0){
				this.closeDB();
				return true;
			}else{
				this.closeDB();
				TempInfo = "���ݲ�����!";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.closeDB();
			return false;
		}
	}
	
	/**
	 * ��ѯ����,�÷���û�йر����ݿ�����,��Ϊ���ܹر�RS�����
	 * @param TableName Ҫ���������ݿ����
	 * @param QueryValue ��Ҫ��ѯ������
	 * @param WhereStr ��ѯ��һ����¼
	 * @return ����һ��ResultSet����
	 */
	public ResultSet queryData(String TableName, String QueryValue, String WhereStr){

		this.SQLStr = "select "+ QueryValue + " from " + TableName + " where " + WhereStr;
		try {
			rs = stmt.executeQuery(SQLStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	/**
	 * ��ѯ����,�÷���û�йر����ݿ�����,��Ϊ���ܹر�RS�����
	 * @param TableName Ҫ���������ݿ����
	 * @param QueryValue ��Ҫ��ѯ������
	 * @param WhereStr ��ѯ��һ����¼
	 * @return ����һ��ResultSet����
	 */
	public ResultSet queryData(String TableName, String QueryValue){
		this.SQLStr = "select "+ QueryValue + " from " + TableName ;
		try {
			rs = stmt.executeQuery(SQLStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rs;
	}
	
}
