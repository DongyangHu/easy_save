package pers.hdy.easy_save.service;

import pers.hdy.easy_save.business.InsertRecordBussiness;
import pers.hdy.easy_save.entity.Record;

public class InsertRecordService {
	public boolean insertRecord (Record record){
		return InsertRecordBussiness.insertRecord(record);
	}
}
