package com.deppon.demo.commons.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtils implements ApplicationContextAware {

	private static ApplicationContext applicationContext;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringBeanUtils.applicationContext = applicationContext;
	}
	
	public static Object getBean(String beanName){
		checkApplicationContext();
		return applicationContext.getBean(beanName);
	}
	
    @SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> clazz) {
        checkApplicationContext();
        Map<?, ?> map = applicationContext.getBeansOfType(clazz);
        return map.isEmpty() ? null : (T) map.values().iterator().next();
    }
    
    
    /**
     * 检查 ApplicationContext 是否注入
     */
    private static void checkApplicationContext() {
        if (null == applicationContext) {
            throw new IllegalStateException("applicaitonContext未注入");
        }
    }
}