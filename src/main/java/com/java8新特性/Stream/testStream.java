/**  
* @Title: testStream.java  
* @Package com.java8新特性.Stream  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年11月7日  
* @version V1.0  
*/  
package com.java8新特性.Stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import com.alibaba.fastjson.JSON;

public class testStream {
	/**
	 * +--------------------+       +------+   +------+   +---+   +-------+
	 * | stream of elements +-----> |filter+-> |sorted+-> |map+-> |collect|
	 * +--------------------+       +------+   +------+   +---+   +-------+
	 * *以上的流程转换为 Java 代码为：
	 * List<Integer> transactionsIds = 
				widgets.stream()
				             .filter(b -> b.getColor() == RED)
				             .sorted((x,y) -> x.getWeight() - y.getWeight())
				             .mapToInt(Widget::getWeight)
				             .sum();
	 */
	public static void main(String[] args) {
		/**
		 * *生成流
		 * stream() − 为集合创建串行流。
		 * parallelStream() − 为集合创建并行流。
		 */
		List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		System.out.println("filter ->"+filtered.toString());
		/**
		 * forEach
		 */
		Random random = new Random();
		random.ints().limit(10).forEach(i ->System.out.print(i+" "));// forEach 输出了10个随机数

		/**
		 * map
		 */
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		// 获取对应的平方数
		List<Integer> squaresList = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
		System.out.println("map ->"+squaresList.toString());
		/**
		 * filter
		 */
		List<String> strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		// 获取空字符串的数量
		long count = strings1.stream().filter(string -> string.isEmpty()).count();
		
		/**
		 * * 并行（parallel）程序
		 */
		List<String> strings2 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		// 获取空字符串的数量
		long count1 = strings2.parallelStream().filter(string -> string.isEmpty()).count();
		
		/**
		 * limit
		 */
		Random random1 = new Random();
		random1.ints().limit(10).forEach(System.out::println);
		
		/**
		 * sorted
		 */
		Random random2 = new Random();
		random2.ints().limit(10).sorted().forEach(System.out::println);
		
		/**
		 * Collectors
		 */
		List<String> strings3 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
		List<String> filtered1 = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
		 
		System.out.println("Collectors->筛选列表: " + filtered1);
		String mergedString = strings3.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
		System.out.println("Collectors->合并字符串: " + mergedString);
		
		/**
		 * *统计
		 */
		List<Integer> numbers1 = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
		 
		IntSummaryStatistics stats = numbers1.stream().mapToInt((x) -> x).summaryStatistics();
		 
		System.out.println("列表中最大的数 : " + stats.getMax());
		System.out.println("列表中最小的数 : " + stats.getMin());
		System.out.println("所有数之和 : " + stats.getSum());
		System.out.println("平均数 : " + stats.getAverage());
	}

}
