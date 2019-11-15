package com.spring.springMVC异常统一处理的三种方式.ControllerAdviceAndExceptionHandler;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)//指定异常，反馈不同信息
    @ResponseBody
    String handleException(Exception e){
    	e.printStackTrace();
        return "Exception Deal!";
    }
    // @ExceptionHandler 注解中未声明要处理的异常类型，则默认为参数列表中的异常类型。所以上面的写法，还可以写成这样：
//    @ExceptionHandler()//指定异常，反馈不同信息
//    @ResponseBody
//    String handleException(Exception e){
//    	return "Exception Deal!";
//    }
}