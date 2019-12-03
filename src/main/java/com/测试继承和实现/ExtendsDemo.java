/**  
* @Title: ExtendsDemo.java  
* @Package com.测试继承和实现  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年11月27日  
* @version V1.0  
*/  
package com.测试继承和实现;

/**  
* <p>Description: </p>
* @ClassName: ExtendsDemo  
* @author wangtz  
* @date 2019年11月27日    
*/
public class ExtendsDemo extends AbstractDemo {

	/**
	* <p>Title: print</p>  
	* <p>Description: </p>    
	* @see com.测试继承和实现.InterfaceDemo#print()  
	*/
	String interfaceString = "ExtendsDemo";
	@Override
	public void print() {
		System.out.println("ExtendsDemo"+interfaceString);

	}

	 

	public static void main(String[] args) {
		ExtendsDemo demo = new ExtendsDemo();
		System.out.println(demo.interfaceString);
		demo.print();
		demo.print2();
		demo.print3();
	}



	/**
	* <p>Title: print3</p>  
	* <p>Description: </p>    
	* @see com.测试继承和实现.AbstractDemo#print3()  
	*/  
	@Override
	void print3() {
		 
		
	}



	
}
