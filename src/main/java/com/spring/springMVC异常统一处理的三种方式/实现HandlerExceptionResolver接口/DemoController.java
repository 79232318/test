/**  
* @Title: DemoController.java  
* @Package com.spring.springMVC异常统一处理的三种方式.实现HandlerExceptionResolver接口  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月12日  
* @version V1.0  
*/  
package com.spring.springMVC异常统一处理的三种方式.实现HandlerExceptionResolver接口;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**  
* <p>Description: </p>
* @ClassName: DemoController  
* @author wangtz  
* @date 2019年10月12日    
*/
@RestController
@RequestMapping("HandlerExceptionResolver")
public class DemoController {

	@RequestMapping("test")       
    public void test() throws Exception {       
        throw new Exception("出错了！");       
    } 
}
