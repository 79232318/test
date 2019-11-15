/**  
* @Title: test.java  
* @Package com.基础.细节  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月27日  
* @version V1.0  
*/  
package com.基础.细节;

/**  
* <p>Description: </p>
* @ClassName: test  
* @author wangtz  
* @date 2019年9月27日    
*/
public class test {

	 
	public static void main(String[] args) {
		
		System.out.println(1+2+"a");
		System.out.println("a"+1+2);
     /**
      * *因为执行的时候是从左到右的，遇到字符串就会强转为字符串。
		所以第一行执行的是：String str=String.valueOf(1+2);     
		               String sb=new StringBuffer(str).append("a").toString();
		第二行执行的是： String sb=new StringBuffer("a").append("1").append("2").toString();
      */
		
		System.out.println(1+2+'a');
		System.out.println('a'+1+2);
		
		/**
		 * 数据类型由低到高为byte/char/short< int < long < float < double，同时char类型向上转型会转化为相应的ASCII码，
		 * ‘a'的ASCII码为97，故1+2+97输出100
		 */
		byte b1=1;
		byte b2=2;
//		byte b3=b1+b2;
		
		/**
		 * 第三行会编译失败，原因在于对byte/short/char进行数值运算时，会强制转换为int类型，最终的结果也是int类型。
              故正确的写法为 byte b3=(byte)(b1+b2)
		 */
		
		Integer i=128;
		Integer j=128;
		System.out.println(i==j);
		/**
		 * Integer存在缓存机制，会自动将-128~127的integer对象缓存在Cache数组中，
		 * 一旦调用Integer.valueOf(i)方法，且-128<=i<=127，则会自动到数组中拿出来，否则就会创建新的Integer对象
		 */
	}

}
