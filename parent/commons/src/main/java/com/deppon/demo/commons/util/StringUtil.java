package com.deppon.demo.commons.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 字符串操作工具类
 * 
 * @ClassName: StringUtil
 * @author & 周禹安 | zhouyuan008@deppon.com
 * @date 2016年11月1日 下午3:33:48
 */
public final class StringUtil {

	public static final String EMPTY_STRING = "";

	private StringUtil() {
	}

	public static boolean isEmpty(String str) {
		return ((str == null) || (str.length() == 0));
	}

	public static boolean isNotEmpty(String str) {
		return ((str != null) && (str.length() > 0));
	}

	/**
	 * 为null或者length为0的视为空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		int length;

		if ((str == null) || (str.length() == 0)) {
			return true;
		}
		length = str.length();
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 为null或者length为0的视为非空
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotBlank(String str) {
		int length;

		if ((str == null) || (str.length() == 0)) {
			return false;
		}
		length = str.length();
		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return true;
			}
		}

		return false;
	}

	public static String defaultIfNull(String str) {
		return (str == null) ? EMPTY_STRING : str;
	}

	public static String defaultIfNull(String str, String defaultStr) {
		return (str == null) ? defaultStr : str;
	}

	/**
	 * @param str
	 * @return
	 * @deprecated 从版本v1.1.0
	 * @see StringUtil.defaultIfNull
	 */
	public static String defaultIfEmpty(String str) {
		return (str == null) ? EMPTY_STRING : str;
	}

	public static String defaultIfEmpty(String str, String defaultStr) {
		return ((str == null) || (str.length() == 0)) ? defaultStr : str;
	}

	public static String defaultIfBlank(String str) {
		return isBlank(str) ? EMPTY_STRING : str;
	}

	public static String defaultIfBlank(String str, String defaultStr) {
		return isBlank(str) ? defaultStr : str;
	}

	public static String trim(String str) {
		return trim(str, null, 0);
	}

	public static String trim(String str, String stripChars) {
		return trim(str, stripChars, 0);
	}

	public static String trimStart(String str) {
		return trim(str, null, -1);
	}

	public static String trimStart(String str, String stripChars) {
		return trim(str, stripChars, -1);
	}

	public static String trimEnd(String str) {
		return trim(str, null, 1);
	}

	public static String trimEnd(String str, String stripChars) {
		return trim(str, stripChars, 1);
	}

	/**
	 * @param str
	 * @return 若trim结果为"",则视为null
	 */
	public static String trimToNull(String str) {
		return trimToNull(str, null);
	}

	/**
	 * @param str
	 * @param stripChars
	 * @return 若trim结果为"",则视为null
	 */
	public static String trimToNull(String str, String stripChars) {
		String result = trim(str, stripChars);

		if ((result == null) || (result.length() == 0)) {
			return null;
		}

		return result;
	}

	/**
	 * @param str
	 * @return 去除字符串中的指定字符，返回结果不为null
	 */
	public static String trimToEmpty(String str) {
		return trimToEmpty(str, null);
	}

	/**
	 * @param str
	 * @param stripChars
	 * @return 去除字符串中的指定字符，返回结果不为null
	 */
	public static String trimToEmpty(String str, String stripChars) {
		String result = trim(str, stripChars);

		if (result == null) {
			return EMPTY_STRING;
		}

		return result;
	}

	private static String trim(String str, String stripChars, int mode) {
		if (str == null) {
			return null;
		}

		int length = str.length();
		int start = 0;
		int end = length;

		if (mode <= 0) {
			if (stripChars == null) {
				while ((start < end)
						&& (Character.isWhitespace(str.charAt(start)))) {
					start++;
				}
			} else if (stripChars.length() == 0) {
				return str;
			} else {
				while ((start < end)
						&& (stripChars.indexOf(str.charAt(start)) != -1)) {
					start++;
				}
			}
		}

		if (mode >= 0) {
			if (stripChars == null) {
				while ((start < end)
						&& (Character.isWhitespace(str.charAt(end - 1)))) {
					end--;
				}
			} else if (stripChars.length() == 0) {
				return str;
			} else {
				while ((start < end)
						&& (stripChars.indexOf(str.charAt(end - 1)) != -1)) {
					end--;
				}
			}
		}

		if ((start > 0) || (end < length)) {
			return str.substring(start, end);
		}

		return str;
	}

	/**
	 * 
	 * <p>
	 * 比较两个字符串是否相等
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:47:50
	 * @param str1
	 * @param str2
	 * @return
	 * @see
	 */
	public static boolean equals(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}

		return str1.equals(str2);
	}

	/**
	 * 
	 * <p>
	 * 忽略比较字符串的大小写
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:48:14
	 * @param str1
	 * @param str2
	 * @return
	 * @see
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		if (str1 == null) {
			return str2 == null;
		}

		return str1.equalsIgnoreCase(str2);
	}

	/**
	 * 
	 * <p>
	 * 判断字符串是否是阿拉伯数字
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:48:51
	 * @param str
	 * @return
	 * @see
	 */
	public static boolean isAlpha(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetter(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断字符串是否包含不可见字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isAlphaSpace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetter(str.charAt(i)) && (str.charAt(i) != ' ')) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断字符串是否不包含非数字或者非字母
	 * 
	 * @param str
	 * @return true：不包含非数字或者非字母;false:不包含非数字或者非字母
	 */
	public static boolean isAlphanumeric(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))) {
				// 非数字或者非字母
				return false;
			}
		}

		return true;
	}

	/**
	 * @param str
	 * @return
	 */
	public static boolean isAlphanumericSpace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isLetterOrDigit(str.charAt(i))
					&& (str.charAt(i) != ' ')) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断字符串是否为十进制数字字符
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isDigit(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 是数字或者包含空格的数字
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumericSpace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		char c;
		for (int i = 0; i < length; i++) {
			c = str.charAt(i);
			if (!Character.isDigit(c) && (!Character.isSpaceChar(c))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 判断字符串是否为空白，空字符串或者空格
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isWhitespace(String str) {
		if (str == null) {
			return false;
		}

		int length = str.length();

		for (int i = 0; i < length; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				return false;
			}
		}

		return true;
	}

	/**
	 * 
	 * <p>
	 * 将字符串转换成大写
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:49:46
	 * @param str
	 * @return
	 * @see
	 */
	public static String toUpperCase(String str) {
		if (str == null) {
			return null;
		}

		return str.toUpperCase();
	}

	/**
	 * 
	 * <p>
	 * 将字符串转化成小写
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:50:07
	 * @param str
	 * @return
	 * @see
	 */
	public static String toLowerCase(String str) {
		if (str == null) {
			return null;
		}

		return str.toLowerCase();
	}

	/**
	 * 
	 * <p>
	 * 拆分字符串
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:50:31
	 * @param str
	 * @return
	 * @see
	 */
	public static String[] split(String str) {
		return split(str, null, -1);
	}

	/**
	 * 
	 * <p>
	 * 指定字符拆分字符串
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:51:14
	 * @param str
	 * @param separatorChar
	 * @return
	 * @see
	 */
	public static String[] split(String str, char separatorChar) {
		if (str == null || str.length() == 0) {
			return new String[0];
		}

		int length = str.length();

		List<String> list = new ArrayList<String>();
		int i = 0;
		int start = 0;
		boolean match = false;

		while (i < length) {
			if (str.charAt(i) == separatorChar) {
				if (match) {
					list.add(str.substring(start, i));
					match = false;
				}

				start = ++i;
				continue;
			}

			match = true;
			i++;
		}

		if (match) {
			list.add(str.substring(start, i));
		}

		return (String[]) list.toArray(new String[list.size()]);
	}

	/**
	 * 
	 * <p>
	 * 指定字符串拆分字符串
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:52:32
	 * @param str
	 * @param separatorChars
	 * @return
	 * @see
	 */
	public static String[] split(String str, String separatorChars) {
		return split(str, separatorChars, -1);
	}

	/**
	 * 
	 * <p>
	 * 指定字符串和长度拆分字符串
	 * </p>
	 * 
	 * @author ningyu
	 * @date 2013-4-1 上午8:53:36
	 * @param str
	 * @param separatorChars
	 * @param max
	 * @return
	 * @see
	 */
	public static String[] split(String str, String separatorChars, int max) {
		if (str == null || str.length() == 0) {
			return new String[0];
		}

		int length = str.length();

		List<String> list = new ArrayList<String>();
		int sizePlus1 = 1;
		int i = 0;
		int start = 0;
		boolean match = false;

		if (separatorChars == null) {
			while (i < length) {
				if (Character.isWhitespace(str.charAt(i))) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		} else if (separatorChars.length() == 1) {
			char sep = separatorChars.charAt(0);

			while (i < length) {
				if (str.charAt(i) == sep) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		} else {
			while (i < length) {
				if (separatorChars.indexOf(str.charAt(i)) >= 0) {
					if (match) {
						if (sizePlus1++ == max) {
							i = length;
						}

						list.add(str.substring(start, i));
						match = false;
					}

					start = ++i;
					continue;
				}

				match = true;
				i++;
			}
		}

		if (match) {
			list.add(str.substring(start, i));
		}

		return (String[]) list.toArray(new String[list.size()]);
	}

	public static String join(Object[] array) {
		return join(array, null);
	}

	/**
	 * 
	 * <p>
	 * 将数组中等于字符长度的字符合并在一起
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:05:16
	 * @param array
	 * @param separator
	 * @return
	 * @see
	 */
	public static String join(Object[] array, char separator) {
		if (array == null) {
			return null;
		}

		int arraySize = array.length;
		int bufSize = (arraySize == 0) ? 0 : ((((array[0] == null) ? 16
				: array[0].toString().length()) + 1) * arraySize);
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if (i > 0) {
				buf.append(separator);
			}

			if (array[i] != null) {
				buf.append(array[i]);
			}
		}

		return buf.toString();
	}

	public static String join(Object[] array, String separator) {
		String sepStr = separator;
		if (array == null) {
			return null;
		}

		if (separator == null) {
			sepStr = EMPTY_STRING;
		}

		int arraySize = array.length;

		if (arraySize == 0) {
			return "";
		}

		int bufSize = (arraySize * (((array[0] == null) ? 16 : array[0]
				.toString().length()) + (/*
										 * ( separator != null ) ?
										 */sepStr.length()
		/* : 0 */)));
		// separator 不需要判断是否为null，可能为null comment by WANGWENHU 2012-07-30
		StringBuffer buf = new StringBuffer(bufSize);

		for (int i = 0; i < arraySize; i++) {
			if (/* (separator != null) && */(i > 0)) {
				buf.append(sepStr);
			}

			if (array[i] != null) {
				buf.append(array[i]);
			}
		}

		return buf.toString();
	}

	public static String join(Iterator<?> iterator, char separator) {
		if (iterator == null) {
			return null;
		}
		StringBuffer buf = new StringBuffer(256); // JavaĬ��ֵ��16, ����ƫС

		while (iterator.hasNext()) {
			Object obj = iterator.next();

			if (obj != null) {
				buf.append(obj);
			}

			if (iterator.hasNext()) {
				buf.append(separator);
			}
		}

		return buf.toString();
	}

	public static String join(Iterator<?> iterator, String separator) {
		if (iterator == null) {
			return null;
		}

		StringBuffer buf = new StringBuffer(256); // JavaĬ��ֵ��16, ����ƫС

		while (iterator.hasNext()) {
			Object obj = iterator.next();

			if (obj != null) {
				buf.append(obj);
			}

			if ((separator != null) && iterator.hasNext()) {
				buf.append(separator);
			}
		}

		return buf.toString();
	}

	/**
	 * 
	 * <p>
	 * 返回字符串中字符的的索引位置
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:09:02
	 * @param str
	 * @param searchChar
	 * @return
	 * @see
	 */
	public static int indexOf(String str, char searchChar) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.indexOf(searchChar);
	}

	/**
	 * 
	 * <p>
	 * 从指定索引处开始搜索,返回该字符串中的指定字符的第一次出现在索引中。
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:11:07
	 * @param str
	 * @param searchChar
	 * @param startPos
	 * @return
	 * @see
	 */
	public static int indexOf(String str, char searchChar, int startPos) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.indexOf(searchChar, startPos);
	}

	/**
	 * 
	 * <p>
	 * 返回在这个字符串中指定的子字符串第一次出现。返回整数的最小的K值
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:12:28
	 * @param str
	 * @param searchStr
	 * @return
	 * @see
	 */
	public static int indexOf(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		return str.indexOf(searchStr);
	}

	public static int indexOf(String str, String searchStr, int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		if ((searchStr.length() == 0) && (startPos >= str.length())) {
			return str.length();
		}

		return str.indexOf(searchStr, startPos);
	}

	public static int indexOfAny(String str, char[] searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length == 0)) {
			return -1;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			for (int j = 0; j < searchChars.length; j++) {
				if (searchChars[j] == ch) {
					return i;
				}
			}
		}

		return -1;
	}

	public static int indexOfAny(String str, String searchChars) {
		if ((str == null) || (str.length() == 0) || (searchChars == null)
				|| (searchChars.length() == 0)) {
			return -1;
		}

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);

			for (int j = 0; j < searchChars.length(); j++) {
				if (searchChars.charAt(j) == ch) {
					return i;
				}
			}
		}

		return -1;
	}

	public static int lastIndexOf(String str, char searchChar) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.lastIndexOf(searchChar);
	}

	/**
	 * @param str
	 * @param searchChar
	 * @param startPos
	 *            从字符串从后向前算字符的起始位置
	 * @return
	 */
	public static int lastIndexOf(String str, char searchChar, int startPos) {
		if ((str == null) || (str.length() == 0)) {
			return -1;
		}

		return str.lastIndexOf(searchChar, startPos);
	}

	public static int lastIndexOf(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		return str.lastIndexOf(searchStr);
	}

	/**
	 * @param str
	 * @param searchStr
	 * @param startPos
	 *            从字符串从后向前算字符的起始位置
	 * @return
	 */
	public static int lastIndexOf(String str, String searchStr, int startPos) {
		if ((str == null) || (searchStr == null)) {
			return -1;
		}

		return str.lastIndexOf(searchStr, startPos);
	}

	public static int lastIndexOfAny(String str, String[] searchStrs) {
		if ((str == null) || (searchStrs == null)) {
			return -1;
		}

		int searchStrsLength = searchStrs.length;
		int index = -1;
		int tmp = 0;

		for (int i = 0; i < searchStrsLength; i++) {
			String search = searchStrs[i];

			if (search == null) {
				continue;
			}

			tmp = str.lastIndexOf(search);

			if (tmp > index) {
				index = tmp;
			}
		}

		return index;
	}

	/**
	 * 
	 * <p>
	 * 字符串中是否包含指定字符
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:14:03
	 * @param str
	 * @param searchChar
	 * @return
	 * @see
	 */
	public static boolean contains(String str, char searchChar) {
		if ((str == null) || (str.length() == 0)) {
			return false;
		}

		return str.indexOf(searchChar) >= 0;
	}

	public static boolean contains(String str, String searchStr) {
		if ((str == null) || (searchStr == null)) {
			return false;
		}

		return str.indexOf(searchStr) >= 0;
	}

	/**
	 * 
	 * <p>
	 * 计算一个字符串中出现一个字符串的次数
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:18:11
	 * @param str
	 * @param subStr
	 * @return
	 * @see
	 */
	public static int countMatches(String str, String subStr) {
		if ((str == null) || (str.length() == 0) || (subStr == null)
				|| (subStr.length() == 0)) {
			return 0;
		}

		int count = 0;
		int index = 0;

		while ((index = str.indexOf(subStr, index)) != -1) {
			count++;
			index += subStr.length();
		}

		return count;
	}

	/**
	 * @param str
	 * @param start
	 *            如果为正数，表示从前往后作为索引截取字符串；如果为负数，则表示从后往前作为索引截取字符串
	 *            <p>
	 *            若start+str.length<0,则从0开始截取字符串
	 *            </p>
	 * @return
	 */
	public static String substring(String str, int start) {
		int iStart = start;
		if (str == null) {
			return null;
		}

		if (start < 0) {
			iStart = str.length() + start;
		}

		if (iStart < 0) {
			iStart = 0;
		}

		// FIX:当相等时，不必继续执行，提高效率 modified by WANGWENHU 2012-07-30
		if (iStart >= str.length()) {
			return EMPTY_STRING;
		}

		return str.substring(iStart);
	}

	/**
	 * 
	 * <p>
	 * 指定截取字符串
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:18:57
	 * @param str
	 * @param start
	 * @param end
	 * @return
	 * @see
	 */
	public static String substring(String str, int start, int end) {
		if (str == null) {
			return null;
		}

		int iEnd = end, iStart = start;
		if (end < 0) {
			iEnd = str.length() + end;
		}

		if (start < 0) {
			iStart = str.length() + start;
		}

		if (iEnd > str.length()) {
			iEnd = str.length();
		}

		if (iStart > iEnd) {
			return EMPTY_STRING;
		}

		if (iStart < 0) {
			iStart = 0;
		}

		if (iEnd < 0) {
			iEnd = 0;
		}

		return str.substring(iStart, iEnd);
	}

	/**
	 * 
	 * <p>
	 * 去除字符串中的空白
	 * </p>
	 * 
	 * @author 平台开发小组
	 * @date 2013-4-1 上午9:20:37
	 * @param str
	 * @return
	 * @see
	 */
	public static String deleteWhitespace(String str) {
		if (str == null) {
			return null;
		}

		int sz = str.length();
		StringBuffer buffer = new StringBuffer(sz);

		for (int i = 0; i < sz; i++) {
			if (!Character.isWhitespace(str.charAt(i))) {
				buffer.append(str.charAt(i));
			}
		}

		return buffer.toString();
	}

	public static String replaceOnce(String text, String repl, String with) {
		return replace(text, repl, with, 1);
	}

	public static String replace(String text, String repl, String with) {
		return replace(text, repl, with, -1);
	}

	public static String replace(String text, String repl, String with, int max) {
		if ((text == null) || (repl == null) || (with == null)
				|| (repl.length() == 0) || (max == 0)) {
			return text;
		}

		StringBuffer buf = new StringBuffer(text.length());
		int start = 0;
		int end = 0;
		int iMax = max;

		while ((end = text.indexOf(repl, start)) != -1) {
			buf.append(text.substring(start, end)).append(with);
			start = end + repl.length();

			if (--iMax == 0) {
				break;
			}
		}

		buf.append(text.substring(start));
		return buf.toString();
	}

}
