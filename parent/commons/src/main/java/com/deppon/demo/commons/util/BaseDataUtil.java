package com.deppon.demo.commons.util;

import org.springframework.util.StringUtils;

/**
 * @ClassName: BaseDataUtil 
 * @Description: 基础数据工具类
 * @author: 273238
 * @date: 2016年11月2日 上午10:16:42
 */
public class BaseDataUtil {
	
	/**
	 * @Description: 获取记录ID
	 * @author: 273238   
	 * @date: 2016年11月2日 上午10:17:21
	 * @param oldId
	 * @param newId
	 * @return
	 * @return: String
	 */
	public static String getLogID(String oldId,String newId){
		//如果原记录为空则直接返回新的ID
		if(StringUtils.isEmpty(oldId)){
			return newId;
		}
		StringBuffer buffer = new StringBuffer();
		String[] strs = oldId.split(";");
		int lenght = strs.length;
		//如果原记录修改次数大于等于5次,则去掉最久的一次，只保存5次修改记录
		if(lenght >= 5){
			for(int i=(lenght-4);i<lenght;i++){
				buffer.append(strs[i]+";");
			}
		}else{
			return buffer.append(oldId+";"+newId).toString();
		}
		return buffer.append(newId).toString();
	}
	
}
