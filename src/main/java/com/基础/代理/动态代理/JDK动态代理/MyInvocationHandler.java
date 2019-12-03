package com.基础.代理.动态代理.JDK动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyInvocationHandler implements InvocationHandler {
	
	private Object target;
	
	public MyInvocationHandler(Object target) {
		
	
		this.target = target;
		
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        PerformanceMonior.begin(target.getClass().getName()+"."+method.getName());
		System.out.println("-----------------begin "+method.getName()+"-----------------");
		Object result = method.invoke(target, args);
		System.out.println("-----------------end "+method.getName()+"-----------------");
//        PerformanceMonior.end();
		return result;
	}
	
	public Object getProxy(){
		
		return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	
	
	public static void main(String[] args) {
		
		UserService service = new UserServiceImpl();
		MyInvocationHandler handler = new MyInvocationHandler(service);
		UserService proxy = (UserService) handler.getProxy();
		proxy.add();
	}
}