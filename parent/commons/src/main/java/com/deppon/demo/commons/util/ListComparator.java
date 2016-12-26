package com.deppon.demo.commons.util;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Comparator;
/**
 * @author 218392 zhangyongxue
 * @date 2016年11月3日 上午8:31:57
 * @see 集合比较器
 */
public class ListComparator implements Comparator<Object>, Serializable{

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1981367831516760391L;

	
	/**
	 *  空:普通的数据类型 非空:对象数据类型 取methodName返回值比较
	 */
	private String methodName;
	
	public ListComparator() {
	}
	
	/**
	 * 初始化
	 * @param fieldName
	 */
	public ListComparator(String fieldName) {
		this.methodName = "get".concat(String.valueOf(
				Character.toUpperCase(fieldName.charAt(0))).concat(
				fieldName.substring(1)));
	}

	public int compare(Object o1, Object o2) {
		int val = -1;
		try {
			if (methodName == null) {
				val = compareObject(o1, o2);
			} else {
				val = compareObject(getValue(o1, methodName),
						getValue(o2, methodName));
			}
		} catch (Exception ex) {
			return -1;
		}
		return val;
	}
	
	/**
	 * 按指定对象排序
	 * 
	 * @author foss-qiaolifeng
	 * @date 2012-12-17 下午8:04:29
	 */
	public int compareObject(Object obj1, Object obj2) throws Exception {
		if (obj1 == null || obj2 == null) {
			return obj1 == null ? -1 : 1;
		}
		Class<? extends Object> cl = obj1.getClass();
		if (obj1 instanceof java.lang.Comparable) {
			// byte int long float..number, date , boolean , char
			Method getMethod = obj1.getClass().getMethod("compareTo",
					new Class[] { cl });
			return (Integer) getMethod.invoke(obj1, new Object[] { obj2 });
		}
		return -1;
	}
	
	/**
	 * 获取排序对象
	 */
	public Object getValue(Object bean, String methodName) throws Exception {
		Method getMethod = bean.getClass().getMethod(methodName);
		return getMethod.invoke(bean);
	}

}
