package com.spring.springboot.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * 过滤器配置
* <p>Description: </p>
* @ClassName: FilterConfig  
* @author wangtz  
* @date 2019年8月6日
 */
@Configuration
public class FilterConfig {
	
     /**
      * 跨域
      */
    @Autowired
    private LogFilter logFilter;
	@Bean
    public FilterRegistrationBean<LogFilter> tlFilterRegistrationBean(){
        FilterRegistrationBean<LogFilter> bean = new FilterRegistrationBean<LogFilter>();
        bean.setFilter(logFilter);
//        执行顺序
        bean.setOrder(1);
        bean.addUrlPatterns("/*");
        return bean;
    }
    
}
