package com.spring.springMVC异常统一处理的三种方式.ExceptionHandler注解;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("ExceptionHandler")  
public class GlobalController {               

   /**    
     * 用于处理异常的    
     * @return    
     */      
    @ExceptionHandler({Exception.class})       
    public String exception(Exception e) {       
        System.out.println(e.getMessage());       
//        e.printStackTrace();       
        return "exception";       
    }       

    @RequestMapping("test")       
    public void test() throws Exception {       
        throw new Exception("出错了！");       
    }                    
}