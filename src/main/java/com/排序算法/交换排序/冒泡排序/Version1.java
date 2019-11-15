/**  
* @Title: Version1.java  
* @Package com.排序算法.冒泡排序  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月8日  
* @version V1.0  
*/  
package com.排序算法.交换排序.冒泡排序;

import java.util.Arrays;

/**  
* <p>Description: </p>
* @ClassName: Version1  
* @author wangtz  
* @date 2019年10月8日    
*/
public class Version1 {

	/**
	 * 
	 * <p>Title:main</p>
	 * <p>Description: </p>
	 *  @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		// 统计比较次数
		int count = 0;
		// 循环比较，从第一个数字开始，到倒数第二个
		for (int i = 0; i < arr.length - 1; i++) {
			// 比较大小，第一次需要比较总数-1次，第二次需要比较总数-2次
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j + 1]) {
					int a = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = a;
				}
				count++;
			}
			
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("一共比较了:" + count + "次");
	}

}
