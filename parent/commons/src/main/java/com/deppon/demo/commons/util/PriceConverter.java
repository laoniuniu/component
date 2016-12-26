package com.deppon.demo.commons.util;

/**
 * 价格转换器 
 *
 */
public class PriceConverter
{	
	/**
	 * 转换字符串显示，单位：元
	 */
	public static String convert(Object oPrice) {
		String sPrice = oPrice.toString();
		Double price = Double.parseDouble(sPrice) / 100;
		return price.toString();
	}
	
	/**
	 * 转换成整型存储，单位：分
	 */
	public static String unconvert(Object oPriceVal) {
		String sPrice = oPriceVal.toString();
		Double price = Double.parseDouble(sPrice) / 100;
		return price.toString();
	}
	/**
	 * 转换成整型存储，类型:long 单位：分
	 */
	public static long unconvertLong(Object oPriceVal) {
		String sPrice = oPriceVal.toString();
		Double price = Double.parseDouble(sPrice) / 100;
		
		return Long.parseLong(price.toString());
	}
}
