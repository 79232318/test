package com.spring.springboot.aop;

 
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

import lombok.extern.slf4j.Slf4j;

/**
 * 对所有controller进行aop
* <p>Description: </p>
* @ClassName: WebExceptionAspect  
* @author wangtz  
* @date 2019年4月12日
 */

@Order(2)
@Slf4j
@Aspect
@Component
public class ControllerAspect {
 
//	 private final String POINT_CUT = "";
	 private final String POINT_CUT = "@annotation(org.springframework.web.bind.annotation.GetMapping)";
//	 private final String POINT_CUT = "execution(public * com.swaggerconfig.UserController.*(..))";
	/**
	 * 凡是注解了RequestMapping的方法都被拦截  
	 * 
	 */
    @Pointcut(POINT_CUT)
    private void webPointcut() {
    
    }
 
    /**
     * 拦截web层异常，记录异常日志，并返回友好信息到前端 目前只拦截Exception，是否要拦截Error需再做考虑
     *
     * @param e
     *            异常对象
     * @return 
     * @throws Exception 
     */
    @AfterThrowing(pointcut = "webPointcut()",throwing="e")
    public void handleThrowing(Exception e) throws Exception {
    	    log.info("这里是controller-AOP-@AfterThrowing");
			
		

    }
   /* @Before(value = "webPointcut()")
    public void doBefore() {
    	log.info("这里是controller-AOP-@Before");
    }
    @Around(value = "webPointcut()")
    public void around() {
    	log.info("这里是controller-AOP-@Around");
    }
    @After(value = "webPointcut()")
    public void after() {
    	log.info("这里是controller-AOP-@After");
    }
    @AfterReturning(value = "webPointcut()")
    public void afterReturning() {
    	log.info("这里是controller-AOP-@AfterReturning");
    }*/
    
}
