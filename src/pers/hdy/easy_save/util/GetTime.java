package pers.hdy.easy_save.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��ȡ��ǰʱ�䣬����ת����12λ�ַ�������201703262157
 * 
 * @author HuDongyang
 *
 */
public class GetTime {
	public static String getTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmm");//�������ڸ�ʽ
		return df.format(new Date());
	}
}
