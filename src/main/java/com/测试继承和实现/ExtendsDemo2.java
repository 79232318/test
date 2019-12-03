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
public class ExtendsDemo2 extends AbstractDemo {

	/**
	* <p>Title: print</p>  
	* <p>Description: </p>    
	* @see com.测试继承和实现.InterfaceDemo#print()  
	*/
	String interfaceString = "ExtendsDemo2";
	@Override
	public void print() {
		System.out.println("ExtendsDemo2"+interfaceString);

	}

	 

	public static void main(String[] args) {
		ExtendsDemo2 demo = new ExtendsDemo2();
		System.out.println(demo.interfaceString);
		demo.print();
		demo.print2();
		
	}



	/**
	* <p>Title: print3</p>  
	* <p>Description: </p>  
	* @param interfaceDemo2  
	* @see com.测试继承和实现.AbstractDemo#print3(com.测试继承和实现.InterfaceDemo2)  
	*/  
	@Override
	void print3() {
		System.out.println("ExtendsDemo"+interfaceString);
		
	}
}
