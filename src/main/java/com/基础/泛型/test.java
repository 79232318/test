/**  
* @Title: test.java  
* @Package com.基础.泛型  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年11月29日  
* @version V1.0  
*/  
package com.基础.泛型;

/**  
* <p>Description: </p>
* @ClassName: test  
* @author wangtz  
* @date 2019年11月29日    
*/
interface demo1{
	
}
class demo2{
	
}
class demo5{
	
}
class demo3 extends demo2 implements demo1{
	
}
class demo4 implements demo1{
	
}
public class test <T extends demo2 & demo1 /*& Comparable<? super T>*/ > {
//	public class test <T extends demo1 & demo2  > {   错误

	/**
	 * 
	 * <p>Title:main</p>
	 * <p>Description: </p>
	 *  @param args
	 */
	public static void main(String[] args) {
		test<demo3> t = new test<demo3>();
//		test<demo4> t = new test<demo4>();
        
	}

}
