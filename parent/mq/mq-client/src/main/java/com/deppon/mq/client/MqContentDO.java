package com.deppon.mq.client;

import java.io.Serializable;

/**
  * @Title mq消息体
  * @author <a href="mailto:liulizheng@deppon.com">267452</a>
  * @version 1.0  
  * @date 2016年12月22日 上午9:46:44
 */
public class MqContentDO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8806646469874288569L;
	/**
	 * 消息ID
	 */
	private String id;
	/**
	 * 内容
	 */
	private String content;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
