package read_source.线程.Thread的State状态笔记;
public class ThreadStateTest {
 
	
	public static void main(String[] args) throws InterruptedException {
		WorkJob wj=new WorkJob();
		Thread t=new Thread(wj);
		System.out.println(String.format("线程没启动的状态:%s",t.getState().name()));
		t.start();
		Thread.sleep(500);
		System.out.println(String.format("线程启动后的状态:%s",t.getState().name()));
		t.interrupt();
		t.join();
		System.out.println(String.format("线程执行完毕的状态:%s",t.getState().name()));
	}
	
	public static class WorkJob implements Runnable{
 
		public void run() {
			Thread curr=Thread.currentThread();
			System.out.println(String.format("线程正在执行的状态:%s",curr.getState().name()));
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(String.format("线程中断后的状态:%s",curr.getState().name()));
			}
			
			
		}
		
	}
	
}