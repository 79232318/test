/**  
* @Title: InterceptorConfig.java  
* @Package com.spring.springboot.intercepter  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月16日  
* @version V1.0  
*/  
package com.spring.springboot.intercepter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**  
 * 其中addInterceptor方法用于把刚才创建的拦截器加入到registry中,
 * addPathPatterns用户加入所要拦截的url，/**表示拦截所有请求。excludePathPatterns添加不需要拦截的请求。
 * 至此，一个拦截器就配置好了。如果需要配置多个拦截，只需要另外创建一个拦截器，给registry再加一个inteceptor就可以了，不用再创建一个新的config配置类。  
*/
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private MyInterceptor myInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
	/*	 静态资源； *.css,*.js
	 * SpringBoot已经做好了静态资源映射registry.addInterceptor(new LoginHandlerInterceptor()).
	 * addPathPatterns("/**")-->/**  表示拦截所有路径下的所有请求
	 * .excludePathPatterns("/index.html","/","/user/login","/static/**","/webjars/**");-->除了什么外
     */
        registry.addInterceptor(myInterceptor)
                .addPathPatterns("/users/**");
	}

}
