/**  
* @Title: ProductProblem.java  
* @Package com.基础.SimpleDateFormat.线程安全问题  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月26日  
* @version V1.0  
*/  
package com.基础.SimpleDateFormat.线程安全问题;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**  
* <p>Description: </p>
* @ClassName: ProductProblem  
* @author wangtz  
* @date 2019年8月26日    
*/
public class ProductProblem {
	private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal = 
			new ThreadLocal<SimpleDateFormat>() {
			    @Override
			    protected SimpleDateFormat initialValue() {
			        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    }
			};
	/**
	 * 
	 * <p>Title:main</p>
	 * <p>Description: </p>
	 *  @param args
	 */
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
	    List<String> dateStrList = new ArrayList<>();
	    dateStrList.add("2018-04-01 10:00:01");
	    dateStrList.add("2018-04-02 11:00:02");
	    dateStrList.add("2018-04-03 12:00:03");
	    dateStrList.add("2018-04-04 13:00:04");
	    dateStrList.add("2018-04-05 14:00:05");
	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");


	    for (String str : dateStrList) {
	        executorService.execute(() -> {
	            try {
	            	Date date = simpleDateFormatThreadLocal.get().parse(str);
//	            	simpleDateFormat.parse(str);
	                TimeUnit.SECONDS.sleep(1);
	                System.out.println(date);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }

	}

}
