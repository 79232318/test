package com;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

 
@EnableAspectJAutoProxy(proxyTargetClass=true)
@SpringBootApplication
@MapperScan("com.bingfa")
public class PracticeApplication extends SpringBootServletInitializer implements TransactionManagementConfigurer{

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(PracticeApplication.class, args);
//		test(run);
	}
	public static void test(ConfigurableApplicationContext run){
        RequestMappingHandlerMapping bean1 = run.getBean(RequestMappingHandlerMapping.class);
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = bean1.getHandlerMethods();
 
        handlerMethods.forEach((k,v)->{
            Set<RequestMethod> methods = k.getMethodsCondition().getMethods();
            if (CollectionUtils.isEmpty(methods)){
                methods = new HashSet<>();
                methods.add(RequestMethod.GET);
                methods.add(RequestMethod.POST);
            }
            final Set<String> patterns = k.getPatternsCondition().getPatterns();
            for (RequestMethod method : methods) {
                for (String pattern : patterns) {
                    System.err.println("method:"+method+" "+"uri:"+pattern);
                    }
            }
        });
	}
	/**
	  * 声明默认的事务管理器
	  */
	  @Resource(name="transactionManager")
	  private PlatformTransactionManager txManagerJ;
	  // 创建事务管理器_Mybatis
	  @Bean(name = "txManagerM")
	  public PlatformTransactionManager txManager(DataSource dataSource) {
	      return new DataSourceTransactionManager(dataSource);
	  }

	   
	  //  JPA事务管理器
	  @Bean(name = "transactionManager")
	  public PlatformTransactionManager txManager2(EntityManagerFactory factory) {
		  
	      return new JpaTransactionManager(factory);
	  }

	  /**
	   *  实现接口 TransactionManagementConfigurer 方法，其返回值代表在拥有多个事务管理器的情况下默认使用的事务管理器
	  * <p>Title: annotationDrivenTransactionManager</p>  
	  * <p>Description: </p>  
	  * @return  
	  * @see org.springframework.transaction.annotation.TransactionManagementConfigurer#annotationDrivenTransactionManager()
	   */
	   
	   @Override
	  public PlatformTransactionManager annotationDrivenTransactionManager() {
		   
	      return txManagerJ;
	  }
}
