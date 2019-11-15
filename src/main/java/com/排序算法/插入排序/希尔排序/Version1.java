/**  
* @Title: Version1.java  
* @Package com.排序算法.选择排序  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月8日  
* @version V1.0  
*/  
package com.排序算法.插入排序.希尔排序;

import java.util.Arrays;

/**  
* <p>Description: </p>
* @ClassName: Version1  
* @author wangtz  
* @date 2019年10月8日    
*/
public class Version1 {

	/**
	 *传统的插入排序算法在某些场景中存在着一些问题，例如[2，3，4，5，1]这样的一个数组，
	 *当我们对其进行插入排序的时候，发现要插入的数字是1，而要想将1插入到最前面，需要经过四个步骤，分别将5、4、3、2后移。
	 *所以得出结论：如果较小的数是我们需要进行插入的数，那效率就会比较低。鉴于这种场景的缺陷，希尔排序诞生了，它是插入排序的一种更高效的版本。
	 *先看看希尔排序的概念：
	 *希尔排序(Shell’s Sort)是插入排序的一种又称“缩小增量排序”（Diminishing Increment Sort），
	 *是直接插入排序算法的一种更高效的改进版本。希尔排序是非稳定排序算法。该方法因D.L.Shell于1959年提出而得名。
	 *希尔排序是把记录按下标的一定增量分组，对每组使用直接插入排序算法排序；随着增量逐渐减少，每组包含的关键词越来越多，
	 *当增量减至1时，整个文件恰被分成一组，算法便终止
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		ShellSort2(arr);
		int arr1[] = { 3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48 };
		ShellSort1(arr1);
	}
    
	public static void ShellSort2(int[] arr) {
		
		//记录排序操作次数
		int count = 0;
		
		//进行分组
		for (int grap = arr.length / 2; grap > 0; grap /= 2) {
			
			//在插入排序
			for (int i = grap; i < arr.length; i++) {
				
				int index = i - grap; 
				int value = arr[i];
				while(index >= 0 && arr[index] > value ){
					arr[index + grap] = arr[index];//往后移
					index -= grap;
					count++;
				}
				arr[index + grap] = value;
				
				
			}
			
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("一共比较了:" + count + "次");
	}
	public static void ShellSort1(int[] arr) {
		
		int count = 0;
		
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 对数组元素进行分组
			for (int i = gap; i < arr.length; i++) {
				// 遍历各组中的元素
				for (int j = i - gap; j >= 0; j -= gap) {
					// 交换元素
					count++;
					if (arr[j] > arr[j + gap]) {
						int temp = arr[j];
						arr[j] = arr[j + gap];
						arr[j + gap] = temp;
					}
				}
			}
		}
		System.out.println(Arrays.toString(arr));
		System.out.println("一共比较了:" + count + "次");
	}

}
