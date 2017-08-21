package pers.hdy.easy_save.business;

import pers.hdy.easy_save.entity.Record;
import pers.hdy.easy_save.util.BaseDao;

public class InsertRecordBussiness {
	public static boolean insertRecord (Record record) {
		BaseDao basedao = new BaseDao();
		basedao.linkDB();
		String TableName = "account_data";
		String WhereStr = "DataID='" + record.getDataID() + "'";
		String InsertValue = "'" + record.getDataID() + "','" + record.getAccount() + "','" + record.getAccount_pw() + "','" + record.getAccount_type() + "','" + record.getCreateTime() + "','" + record.getUserID() +"'";
		if (basedao.insertData(TableName, InsertValue, WhereStr)) {
			basedao.closeDB();
			return true;
		} else {
			basedao.closeDB();
			return false;
		}
		
	}
}
