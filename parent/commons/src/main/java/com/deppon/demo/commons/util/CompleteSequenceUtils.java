package com.deppon.demo.commons.util;
/**
 * @author 218392 zhangyongxue
 * @date 2016年11月1日 下午4:43:36
 * @see 获取序列判断是否满足14位，不满足则前面补0
 */
public class CompleteSequenceUtils {
	/**
	 * 单个参数
	 * @param sequence
	 */
	public void completeConvert(Long sequence){
		/**
		 * 获取sequence序列，不满14位前位补0
		 */
		String str = sequence.toString();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 14 - str.length(); i++) {
			sb.append("0");
		}
		sb.append(str);
		str = sb.toString();
		sequence = Long.parseLong(str);
	}
	
	/**
	 * 双参数
	 * @param sequence
	 * @param billNo
	 */
	public void completeConvertDouble(Long sequence , String billNo){
		
		/**
		 * 首先获取sequence序列，不满14位前位补0
		 */
		String str = sequence.toString();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < 14 - str.length(); i++) {
			sb.append("1");
		}
		sb.append(str);
		
		/**
		 * 其次截取字符串billNo后四位，与前14位拼接
		 */
		String strsub=billNo.substring(billNo.length()- 4);
		sb.append(strsub);
		
		str = sb.toString();
	}
}
