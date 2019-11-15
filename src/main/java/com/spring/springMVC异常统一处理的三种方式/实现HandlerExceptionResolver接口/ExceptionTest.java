package com.spring.springMVC异常统一处理的三种方式.实现HandlerExceptionResolver接口;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Component  
public class ExceptionTest implements HandlerExceptionResolver{  

    /**  
     * TODO 简单描述该方法的实现功能（可选）.  
     * @see org.springframework.web.servlet.HandlerExceptionResolver#resolveException(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, java.lang.Object, java.lang.Exception)  
     */   
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  
            Exception ex) {  
        System.out.println("This is exception handler method!");  
        return null;  
    }  
}