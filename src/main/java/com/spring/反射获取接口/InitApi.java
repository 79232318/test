/**  
* @Title: InitApi.java  
* @Package com.spring.反射获取接口  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月16日  
* @version V1.0  
*/  
package com.spring.反射获取接口;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;

/**  
* <p>Description: </p>
* @ClassName: InitApi  
* @author wangtz  
* @date 2019年10月16日    
*/
@Component
public class InitApi implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	/**
	* <p>Title: setApplicationContext</p>  
	* <p>Description: </p>  
	* @param applicationContext
	* @throws BeansException  
	* @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)  
	*/
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	//获取带有controller的类
	public List<Class> getController() {
		Map<String, Object> restMap = applicationContext.getBeansWithAnnotation(RestController.class);
		Map<String, Object> map = applicationContext.getBeansWithAnnotation(Controller.class);
		restMap.putAll(map);
		List<Class> clazzs = new ArrayList<>();
		for(Entry<String, Object> entry : restMap.entrySet()) {
			Class clazz = entry.getValue().getClass();
			if(clazz.getName().contains("$$EnhancerBySpringCGLIB$$")) {
				transfCligController(clazz);
			}
			clazzs.add(clazz);
		}
		return clazzs;
	}
	//获取uri
	public void getUri(Class clazz) {
		//获取头部uri
		RequestMapping requestMapping = (RequestMapping) clazz.getDeclaredAnnotation(RequestMapping.class);
		Set<String> headUris = new HashSet<>();
 		if(requestMapping != null) {
			for (String uri : requestMapping.value()) {
			
				simplify(uri);
			}
		}
	}
	private boolean checkUri(String uri) {
		uri.replace("/", "");
		return false;
	}
	private String simplify(String uri) {
		while(uri.startsWith("/")) {
			
		}
		if(!uri.startsWith("/")) {
			uri = "/" + uri;
		}
		if(uri.endsWith("/")) {
			uri = uri.substring(0, uri.length() - 1);
		}
		return uri; 
	}
//		String uri = "/";
//		String u = "/";
//		Set<String> set = new HashSet<>();
//		
//		RequestMapping requestMapping = (RequestMapping) clazz.getDeclaredAnnotation(RequestMapping.class);
//		if(requestMapping != null) {
//			for (String s : requestMapping.value()) {
//				if(s.startsWith("/")) {
//					s = s.substring(1, s.length());
//				}
//				if(s.endsWith("/")) {
//					s = s.substring(0, s.length() - 1);
//				}
//				s = "/" + s + "/";
//				set.add(s);
//			}
//		}
//		
//		Method[] ms = clazz.getMethods();
//		for (int i = 0; i < ms.length; i++) {
//			Annotation[] annotations1 = ms[i].getAnnotations();
//			//方法上的注解
//			for (Annotation annotation : annotations1) {
//				uri = u;
//				Annotation[] annotations2 = annotation.annotationType().getAnnotations();
//				//方法上的注解上的注解
//				 String method = "";
//				 Boolean flag = false;
//                 for (Annotation annotation2 : annotations2) {
//                	 //为put、get、post、delete
//                	
//                	 if(annotation2 instanceof RequestMapping) {
//                		 flag = true;
//                		 RequestMapping r3 = (RequestMapping) annotation2;
//                		 method = requestMethodToString(r3.method());
//                		for (RequestMethod m : r3.method()) {
//                			switch (m+"") {
//                			case "GET":
//                				GetMapping r2 = (GetMapping) annotation;
//                				if(r2 != null) {
//                					uri += Arrays.toString(r2.value());
//                				}
//                				break;
//                			case "POST":
//                				PostMapping r4 = (PostMapping) annotation;
//                				if(r4 != null) {
//                					uri += Arrays.toString(r4.value());
//                				}
//                				break;
//                			case "PUT":
//                				PutMapping r5 = (PutMapping) annotation;
//                				if(r5 != null) {
//                					uri += Arrays.toString(r5.value());
//                				}
//                				break;
//                			case "DELETE":
//                				DeleteMapping r6 = (DeleteMapping) annotation;
//                				if(r6 != null) {
//                					uri += Arrays.toString(r6.value());
//                				}
//                				break;
//                				
//                			default:
//                				break;
//                			}
//						}
//                		 
//                	 }else if(annotation2 instanceof Mapping) {
//                		 flag = true;
//                		 RequestMapping r2 = (RequestMapping) annotation;
//                		 if(r2 != null) {
//                			 uri += Arrays.toString(r2.value());
//                		 }
//                		 method = requestMethodToString(r2.method());
//                	 }
//            		
//				}
//                 if(flag) {
//                	 uri += "--------请求方式" + method;
//                	 System.out.println(uri);
//                 }
//        		 
//
//			
//				
//			}
//			
//	}
	//获取请求方式
	//获取参数
//		if(annotation instanceof RequestMapping || annotation instanceof PutMapping) {
//
//			// 得到方法的返回值类型的类类型
//			Class<?> returnType = ms[i].getReturnType();
//			ApiImplicitParams apiImplicitParams = ms[i].getAnnotation(ApiImplicitParams.class);
//			if(apiImplicitParams != null) {
//				for (ApiImplicitParam a : apiImplicitParams.value()) {
//					System.out.println(a.name()+a.required()+a.dataType());
//				} 
//			}
//			ApiImplicitParam apiImplicitParam = ms[i].getAnnotation(ApiImplicitParam.class);
//			if(apiImplicitParam != null) {
//				System.out.println(apiImplicitParam.name()+apiImplicitParam.required()+apiImplicitParam.dataType());
//			}
//			// 得到方法的名称
//			System.out.print("方法"+ms[i].getName() + "(");
//			// 获取参数类型
//			Class[] paramTypes = ms[i].getParameterTypes();
//			Parameter[] params = ms[i].getParameters();
//			for (Parameter parameter : params) {
//				System.out.print(parameter.getName());
//			}
//			int count = 0;
//			for (Class class2 : paramTypes) {
//				System.out.print(class2.getSimpleName() );
//				count++;
//				if(count != paramTypes.length) {
//					System.out.print( ",");
//				}
//				
//			}
//			
//			System.out.print(")   ");
//			System.out.println("返回值类型"+returnType.getSimpleName() + " ");
//		
//		}
	
	/**
	 * 
	 * <p>Title:transfCligController</p>
	 * <p>Description: </p>
	 */
	private Class transfCligController(Class clazz) {
		int index = clazz.getName().indexOf("$$EnhancerBySpringCGLIB$$");
		String name = clazz.getName().substring(0, index);
		try {
			clazz = clazz.forName(name);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clazz;
	}

	private String requestMethodToString(RequestMethod[] requestMethods) {
		String method = "";
		for (RequestMethod requestMethod : requestMethods) {
			method += requestMethod + "";
		}
		return method;
	}

}
