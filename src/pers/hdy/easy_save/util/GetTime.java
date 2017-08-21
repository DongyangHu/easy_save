package pers.hdy.easy_save.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取当前时间，将其转换成12位字符串，如201703262157
 * 
 * @author HuDongyang
 *
 */
public class GetTime {
	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//设置日期格式
		return df.format(new Date());
	}
}
