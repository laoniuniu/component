package com.deppon.demo.commons.util;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.params.HttpClientParams;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * Restful客户端公共请求类
 * 
 * @ClassName: HttpClientUtil
 * @author & 周禹安 | zhouyuan008@deppon.com
 * @date 2016年12月13日 下午12:59:56
 */
public class HttpClientUtil {
	/**
	 * 常量设置
	 */
	public static MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
	public static HttpClient httpClient = new HttpClient(connectionManager);
	public static HttpConnectionManagerParams params = new HttpConnectionManagerParams();
	public static HttpClientParams httpClientParams = new HttpClientParams();
	static {
		params.setConnectionTimeout(20000);
		params.setSoTimeout(20000);
		params.setMaxTotalConnections(500);
		params.setDefaultMaxConnectionsPerHost(500);
		params.setStaleCheckingEnabled(true);
		connectionManager.setParams(params);
		// 设置连接超时两分钟
		httpClientParams.setConnectionManagerTimeout(20000);
		httpClient.setParams(httpClientParams);

		httpClientParams.setParameter(HttpMethodParams.RETRY_HANDLER,
				new DefaultHttpMethodRetryHandler(0, false));
		httpClient.setHttpConnectionManager(connectionManager);
		// 编码设置
		httpClient.getParams().setContentCharset("UTF-8");
	}

	/**
	 * 客户端发送请求
	 * 
	 * @Title: postRequest
	 * @author： & 周禹安 |zhouyuan008@deppon.com
	 * @date 2016年12月13日 下午1:05:30
	 */
	public static String postRequest(String url, RequestEntity requestEntity)
			throws Exception {
		String returnStr = "";
		PostMethod postMethod = new PostMethod(url);
		postMethod.setRequestEntity(requestEntity);
		try {
			httpClient.executeMethod(postMethod);
			returnStr = postMethod.getResponseBodyAsString();
		} catch (Exception e) {
			throw e;
		} finally {
			if (null != postMethod) {
				postMethod.releaseConnection();
			}
		}
		return returnStr;
	}

}