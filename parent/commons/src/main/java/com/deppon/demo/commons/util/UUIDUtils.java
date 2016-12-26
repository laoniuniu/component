package com.deppon.demo.commons.util;

import java.util.UUID;

/**
 * @author 218392 zhangyongxue
 * @date 2016年11月2日 上午11:05:33
 * @see 通过jdk自带的uuid生成器生成36位的uuid
 */
public class UUIDUtils {

	public static String getUUID() {
		// 使用JDK自带的UUID生成器
		return UUID.randomUUID().toString();
	}
}
