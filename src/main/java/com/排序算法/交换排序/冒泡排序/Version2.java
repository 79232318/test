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
* Version1这段程序有个缺点，就是当排序过程中已经将数组元素排序完成，
* 但此时它仍然会去比较，这就做了无用功了，所以我们可以通过一个boolean变量来优化这段代，
* 上面的程序中我们已经得出了比较次数为105次。  
*/
public class Version2 {

	/**
	 * 
	 * <p>Title:main</p>
	 * <p>Description: </p>
	 *  @param args
	 */
	public static void main(String[] args) {
//		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		int[] arr = { 5, 1, 4, 3, 2 };
		// 统计比较次数
		int count = 0;
		// 循环比较，从第一个数字开始，到倒数第二个
		for (int i = 0; i < arr.length - 1; i++) {
			// 比较大小，第一次需要比较总数-1次，第二次需要比较总数-2次
			boolean flag = true;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				
				if(arr[j] > arr[j + 1]) {
					//代表需要排序
					int a = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = a;
					flag = false;
				}else{
					//代表当前j 和 j+1 位置上的数字不需要排序，当前顺序符合
				}
				
				count++;
			}
			if(flag) {
				break;
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("一共比较了:" + count + "次");
	}

}
