/**  
* @Title: Snippet.java  
* @Package com.设计模式.工厂模式.简单工厂.应用场景  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月17日  
* @version V1.0  
*/  
package com.设计模式.工厂模式.简单工厂.应用场景;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.CacheManager;

/**  
* <p>Description: </p>
* @ClassName: Snippet  
* @author wangtz  
* @date 2019年9月17日    
*/  
public class Snippet {
	//这个代码大家应该很熟悉
	Logger logger = LoggerFactory.getLogger(CacheManager.class);
	
	//看下它的实现
//	public static Logger getLogger(String name) {
//	    ILoggerFactory iLoggerFactory = getILoggerFactory();
//	    return iLoggerFactory.getLogger(name);
//	}
//	
//	public static Logger getLogger(Class<?> clazz) {
//	    Logger logger = getLogger(clazz.getName());
//	    if (DETECT_LOGGER_NAME_MISMATCH) {
//	        Class<?> autoComputedCallingClass = Util.getCallingClass();
//	        if (autoComputedCallingClass != null && nonMatchingClasses(clazz, autoComputedCallingClass)) {
//	            Util.report(String.format("Detected logger name mismatch. Given name: \"%s\"; computed name: \"%s\".", logger.getName(), autoComputedCallingClass.getName()));
//	            Util.report("See http://www.slf4j.org/codes.html#loggerNameMismatch for an explanation");
//	        }
//	    }
//	
//	    return logger;
//	}
}

