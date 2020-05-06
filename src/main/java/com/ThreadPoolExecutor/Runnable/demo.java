/**  
* @Title: demo.java  
* @Package com.ThreadPoolExecutor  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年12月5日  
* @version V1.0  
*/  
package com.ThreadPoolExecutor.Runnable;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**  
* <p>Description: </p>
* @ClassName: demo  
* @author wangtz  
* @date 2019年12月5日    
*/
public class demo {

	private static final int CORE_POOL_SIZE = 5;
    private static final int MAX_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 100;
    private static final Long KEEP_ALIVE_TIME = 1L;
	/**
	 * 
	 * <p>Title:main</p>
	 * <p>Description: </p>
	 *  @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor executor  = new ThreadPoolExecutor(
				CORE_POOL_SIZE, //核心线程数，定义最小可以同时运行的线程数
				MAX_POOL_SIZE, //最大线程数，当队列中队列数量达到队列容量时，当前可以同时运行的线程数量变成最大线程数
				KEEP_ALIVE_TIME,//当线程数大于核心线程数时，没有任务的线程的存活时间
				TimeUnit.SECONDS, //keepalivetime 单位
				new ArrayBlockingQueue<>(QUEUE_CAPACITY),//当来新任务时，如果线程数达到了核心线程数，就讲任务放到队列中
				/*threadFactory,*/ //executor 创建新线程的时候会用到。
				new ThreadPoolExecutor.CallerRunsPolicy()//饱和策略(如果当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任时)。关于饱和策略下面单独介绍一下。
														//ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。
														//ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务。您不会任务请求。但是这种策略会降低对于新任务提交速度，影响程序的整体性能。另外，这个策略喜欢增加队列容量。如果您的应用程序可以承受此延迟并且你不能任务丢弃任何一个任务请求的话，你可以选择这个策略。
														//ThreadPoolExecutor.DiscardPolicy： 不处理新任务，直接丢弃掉。
														//ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。		
				);
		//输出结果标识，队列没满，一直使用核心数来执行
		    for (int i = 0; i < 10; i++) {
	            //创建WorkerThread对象（WorkerThread类实现了Runnable 接口）
	            Runnable worker = new MyRunnable("" + i);
	            //执行Runnable
	            executor.execute(worker);
	        }
	        //终止线程池
	        executor.shutdown();
	        while (!executor.isTerminated()) {
	        }
	        System.out.println("Finished all threads");
	         
	}

}
