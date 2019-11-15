/**  
* @Title: WebExceptionHandle.java  
* @Package com.spring.springMVC异常统一处理的三种方式.ControllerAdviceAndExceptionHandler  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月14日  
* @version V1.0  
*/  
package com.spring.springMVC异常统一处理的三种方式.ControllerAdviceAndExceptionHandler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
* <p>Description: </p>
* @ClassName: WebExceptionHandle  
* @author wangtz  
* @date 2019年10月14日    
*/
@RestController
@ControllerAdvice
@RequestMapping("controllerAdvice")
public class WebExceptionHandle {
   
	@RequestMapping("test")
	public String test() throws Exception {
		throw new Exception("controllerAdvice 异常");
	}
}
