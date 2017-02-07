package com.deppon.kibana.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *  日志打印接口实现.
 * @author llg
 * @Date: 2016-09-29 13:49:59
 */
public class MonitorInterfaceLogService  {
	
	
	/**
	 * 日志文件输出 notice_log
	 */
	private static  Logger monitorLogger = LoggerFactory.getLogger(MonitorInterfaceLogService.class);
	
	//private static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss:SSSZZ";
	private static final int NUMBER_INT_VALUE200 = 200;
	
	public void logInfo(String service,String api,Long start, int codePoint,String errorMsg,int flag) {
		// TODO Auto-generated method stub
		monitorLogger.error(logAppend(service,api,start,codePoint,errorMsg,flag));
	}
	
	
	
	
	
	private String logAppend(String service,String api,Long start,  int codePoint,String errorMsg,int flag){
		StringBuffer strBuf = new StringBuffer();
		
		//日志打印时间
		strBuf.append("ts=");
		//strBuf.append(DateFormatUtils.format(new java.util.Date(), PATTERN));
		strBuf.append("`");
		//线程ID
		strBuf.append("thread_id=");
		strBuf.append(Thread.currentThread().getId());
		//服务名称
		strBuf.append("`");
		strBuf.append("service=");
		strBuf.append(service);
		//接口地址
		strBuf.append("`");
		strBuf.append("api=");
		strBuf.append(api);
		//本机IP地址
		strBuf.append("`");
		strBuf.append("src_ip=");
		//strBuf.append(request.getRemoteAddr());
		//本机端口
		strBuf.append("`");
		strBuf.append("src_port=");
		//strBuf.append(request.getRemotePort());
		//服务端响应状态
		strBuf.append("`");
		strBuf.append("status=");
		strBuf.append(NUMBER_INT_VALUE200);
		//是否成功
		strBuf.append("`");
		strBuf.append("code=");
		strBuf.append(flag==0 ? 0:1);
		//请求响应时间
		strBuf.append("`");
		strBuf.append("delay=");
		strBuf.append(System.currentTimeMillis()-start);
		//代码位置
		strBuf.append("`");
		strBuf.append("code_point=");
		strBuf.append(codePoint);
		//错误堆栈
		strBuf.append("`");
		strBuf.append("err_stack=");
		strBuf.append(errorMsg);
		return strBuf.toString();
	}










}
