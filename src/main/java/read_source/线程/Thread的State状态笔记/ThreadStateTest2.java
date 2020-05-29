package read_source.线程.Thread的State状态笔记;
public class ThreadStateTest2 {
	
	public static void main(String[] args) throws InterruptedException {
		WorkJob wj=new WorkJob();
		Thread t1=new Thread(wj,"w1");
		t1.start();
		Thread.sleep(500);
		System.out.println(String.format("线程%s启动后的状态:%s",t1.getName(),t1.getState().name()));
		Thread t2=new Thread(wj,"w2");
		t2.start();
		Thread.sleep(500);
		System.out.println(String.format("线程%s启动后的状态:%s",t2.getName(),t2.getState().name()));
		
	}
	
	public static class WorkJob implements Runnable{
 
		
		public void run() {
			Thread curr=Thread.currentThread();
			System.out.println(String.format("线程%s--synch代码块的状态:%s",curr.getName(),curr.getState().name()));
			synchronized (ThreadStateTest2.class) {
				try {
					curr.sleep(3000);
				} catch (InterruptedException e) {
				}
			}
		}
		
	}
}