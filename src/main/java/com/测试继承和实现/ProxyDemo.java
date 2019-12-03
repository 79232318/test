/**  
* @Title: ProxtDemo.java  
* @Package com.测试继承和实现  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年11月27日  
* @version V1.0  
*/  
package com.测试继承和实现;

/**  
* <p>Description: </p>
* @ClassName: ProxtDemo  
* @author wangtz  
* @date 2019年11月27日    
*/
public class ProxyDemo implements InterfaceDemo {

	private  InterfaceDemo interfaceDemo;
	public ProxyDemo(InterfaceDemo interfaceDemo) {
		this.interfaceDemo = interfaceDemo;
	}
	/**
	* <p>Title: print</p>  
	* <p>Description: </p>    
	* @see com.测试继承和实现.InterfaceDemo#print()  
	*/  
	@Override
	public void print() {
		interfaceDemo.print();
		
	}
	public static void print2(InterfaceDemo interfaceDemo) {
		interfaceDemo.print();
	}
	public static void main(String[] args) {
		ProxyDemo proxyDemo = new ProxyDemo(new ExtendsDemo());
		proxyDemo.print();
		ProxyDemo proxyDemo2 = new ProxyDemo(new ExtendsDemo2());
		proxyDemo2.print();
		ProxyDemo.print2(new ExtendsDemo());
		ProxyDemo.print2(new ExtendsDemo2());
		 
	}

	
}
