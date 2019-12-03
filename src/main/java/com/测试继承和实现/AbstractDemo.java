/**  
* @Title: AbstractDemo.java  
* @Package com.测试继承和实现  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年11月27日  
* @version V1.0  
*/  
package com.测试继承和实现;

/**  
* <p>Description: </p>
* @ClassName: AbstractDemo  
* @author wangtz  
* @date 2019年11月27日    
*/
public abstract class AbstractDemo implements InterfaceDemo2 {

	

	String interfaceString = "抽象";
	abstract void print3();
	 
	public void print2() {
		System.out.println("AbstractDemo.print2()");
	}
	
	static void print4() {
		System.out.println("AbstractDemo.print4()");
	}
}
