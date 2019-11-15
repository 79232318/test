/**  
* @Title: MyIntercepter.java  
* @Package com.spring.springboot.intercepter  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月16日  
* @version V1.0  
*/  
package com.spring.springboot.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

/**  
* <p>Description: </p>
* @ClassName: MyIntercepter  
* @author wangtz  
* @date 2019年10月16日    
*/
@Slf4j
@Component
public class MyInterceptor implements HandlerInterceptor {

	@Override//在一个请求进入Controller层方法执行前执行这个方法
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//在这里可以对参数做一些预处理和做一些验证
		log.info("进入 preHandle 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
		return true;//方法给予执行，就是允许controller的方法进行执行
		//false 不允许，可以在这之前在reponse中编写返回的结果
	}

	@Override//返回model前
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//Controller执行完毕后，返回之前，可以对request和reponse进行处理
        //如果是前后端没有分离，在进入View层中前执行
		log.info("进入 postHandle 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());
	}

	@Override //返回model后
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		  //在一个请求处理完毕，即将销毁的时候，执行，可以做一些资源释放之类的工作
		 log.info("进入 afterCompletion 方法..." + request.getRequestURL().toString() + "," + request.getRequestURI());

	}

	
	
}
