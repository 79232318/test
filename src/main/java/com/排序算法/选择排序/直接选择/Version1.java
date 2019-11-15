/**  
* @Title: Version1.java  
* @Package com.排序算法.选择排序  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月8日  
* @version V1.0  
*/  
package com.排序算法.选择排序.直接选择;

import java.util.Arrays;

/**  
* <p>Description: </p>
* @ClassName: Version1  
* @author wangtz  
* @date 2019年10月8日    
*/
public class Version1 {

	/**
	 * 工作原理是：第一次从待排序的数据元素中选出最小（或最大）的一个元素，存放在序列的起始位置，
	 * 然后再从剩余的未排序元素中寻找到最小（大）元素，然后放到已排序的序列的末尾。
	 * 以此类推，直到全部待排序的数据元素的个数为零。选择排序是不稳定的排序方法。
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
//		int[] arr = { 5, 1, 4, 3, 2 };
		//记录排序操作次数
		int count = 0;
		
		//从第一个数字开始，最后一个不需要比较
		for (int i = 0; i < arr.length - 1 ; i++) {
			int index = i;
			//默认定义第一个为最小值，如果后面的小于这个值，就替换掉
			for (int j = i + 1; j < arr.length; j++) {
				if(arr[index] > arr[j]) {
					index = j;
				}
				count++;
			}
			int a = arr[i];
			arr[i] = arr[index];
			arr[index] = a;
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("一共比较了:" + count + "次");
	}

}
