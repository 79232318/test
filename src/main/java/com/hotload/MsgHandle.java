package com.hotload;
/**
 * 
* <p>Description: 后台启动一条线程，不断检测是否要刷新重新加载，实现了热加载的类</p>
* @ClassName: MsgHandle  
* @author wangtz  
* @date 2019年12月11日
 */
public class MsgHandle implements Runnable {
    @Override
    public void run() {
    	//一直轮询，不断检测是否要刷新重新加载，实现了热加载的类
        while (true) {
        	 ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}