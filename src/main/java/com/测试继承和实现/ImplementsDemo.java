/**  
* @Title: ImplementsDemo.java  
* @Package com.测试继承和实现  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年11月27日  
* @version V1.0  
*/  
package com.测试继承和实现;

/**  
* <p>Description: </p>
* @ClassName: ImplementsDemo  
* @author wangtz  
* @date 2019年11月27日    
*/
public class ImplementsDemo implements InterfaceDemo2 {

	/**
	* <p>Title: print</p>  
	* <p>Description: </p>    
	* @see com.测试继承和实现.InterfaceDemo#print()  
	*/
	@Override
	public void print() {
		System.out.println("print()"+interfaceString);

	}

	/**
	* <p>Title: print2</p>  
	* <p>Description: </p>    
	* @see com.测试继承和实现.InterfaceDemo2#print2()  
	*/  
	@Override
	public void print2() {
		// TODO Auto-generated method stub
		
	}
	 

	public static void main(String[] args) {
		ImplementsDemo demo = new ImplementsDemo();
		System.out.println(interfaceString);
		System.out.println(demo.interfaceString);
		demo.print2();
		demo.print();
		AbstractDemo.print4();
	}



}
