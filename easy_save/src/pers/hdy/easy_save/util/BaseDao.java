package pers.hdy.easy_save.util;

import java.sql.*;
/**
 * 连接easy_save数据库，以及对数据库的增删改查操作
 * @author HuDongyang
 *
 */
public class BaseDao {
	
	//驱动路径
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	//数据库地址
	private String DBURL = "jdbc:mysql://localhost:3306/easy_save?characterEncoding=utf8";
	//数据库登录用户名
	private static final String DBUSER = "root";
	//数据库用户密码
	private static final String DBPASSWORD = "123456";
	
	/***********************************************************************************************/
	//数据库连接
	public Connection conn = null;
	//执行SQL语句的接口
	public Statement stmt = null;
	//要执行的SQL语句
	public String SQLStr = null;
	//数据容器
	public ResultSet rs = null;
	//提示信息
	public String TempInfo = "";
	
	
	//构造方法
	public BaseDao() {
		
	}
	
	
	/**
	 * 连接数据库
	 * @return 成功返回true,失败返回false
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
	 * 关闭数据库连接
	 * @return 成功返回true，失败返回false
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
	 * 添加数据
	 * @param TableName 要操作的数据库表名
	 * @param InsertValue 要增加的数据
	 * @param WhereStr 查询表中是否已存在要新增的信息
	 * @return 成功返回true,失败返回false
	 */
	public boolean insertData(String TableName, String InsertValue, String WhereStr){
		this.SQLStr = "insert into " + TableName + " values (" + InsertValue + ")";
		try {
			if(stmt.executeQuery("select * from " + TableName + " where " + WhereStr).next()){
				TempInfo = "该记录已存在!";
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
	 * 删除数据
	 * @param TableName 要操作的数据库表名
	 * @param WhereStr 删除哪一条记录
	 * @return 成功返回true,失败返回false
	 */
	public boolean deleteData(String TableName, String WhereStr){
		this.SQLStr = "delete from " + TableName + " where " + WhereStr;
		try {
			if(stmt.executeUpdate(SQLStr) != 0){
				this.closeDB();
				return true;
			}else{
				this.closeDB();
				TempInfo = "数据不存在!";
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			this.closeDB();
			return false;
		}
	}
	
	/**
	 * 修改数据
	 * @param TableName  要操作的数据库表名
	 * @param UpdateValue  要修改的属性
	 * @param WhereStr 要修改哪一条记录
	 * @return 成功返回true,失败返回false
	 */
	public boolean updateData (String TableName, String UpdateValue, String WhereStr){
		this.SQLStr = "update " + TableName + " set " + UpdateValue + " where " + WhereStr;
		try {
			if(stmt.executeUpdate(SQLStr) != 0){
				this.closeDB();
				return true;
			}else{
				this.closeDB();
				TempInfo = "数据不存在!";
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			this.closeDB();
			return false;
		}
	}
	
	/**
	 * 查询数据,该方法没有关闭数据库连接,因为不能关闭RS结果集
	 * @param TableName 要操作的数据库表名
	 * @param QueryValue 需要查询的数据
	 * @param WhereStr 查询哪一条记录
	 * @return 返回一个ResultSet集合
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
	 * 查询数据,该方法没有关闭数据库连接,因为不能关闭RS结果集
	 * @param TableName 要操作的数据库表名
	 * @param QueryValue 需要查询的数据
	 * @param WhereStr 查询哪一条记录
	 * @return 返回一个ResultSet集合
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
