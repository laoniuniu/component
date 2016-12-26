package com.deppon.demo.commons.util;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
import org.springframework.web.context.WebApplicationContext;

public class WebApplicationContextUtils implements ServletContextAware {
	private static ThreadLocal<ServletContext> threadLocal = new ThreadLocal<ServletContext>();
	private static WebApplicationContext webApplicationContext = null;

	public static void initWebApplicationContext(ServletContext servletContext) {
		if (null == threadLocal.get()) {
			threadLocal.set(servletContext);
		}
		webApplicationContext = (WebApplicationContext) threadLocal.get().getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);
	}

	public static WebApplicationContext getWebApplicationContext() {
		return webApplicationContext;
	}

	public static ServletContext getServletContext() {
		return threadLocal.get();
	}

	public void setServletContext(ServletContext paramServletContext) {

	}

}
