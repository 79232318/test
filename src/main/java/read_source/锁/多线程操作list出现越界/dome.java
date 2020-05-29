package read_source.锁.多线程操作list出现越界;
import java.util.ArrayList;
import java.util.List;
 /**
  * 如果单线程是不会出现越界的情况的，因为list在不够用的时候回扩容，
  * 但是多线程来说，在list正要准备扩容的时候，理应不能对list进行操作的，
  * 但是没有相关代码进行处理，所以在扩容的时候， 有线程继续往里面添加元素，导致数组越界
  * @author user
  */
public class dome implements Runnable{
	public static List<Integer> numberList = new ArrayList<Integer>();
	int startNum = 0;
	public dome(int startNum){
		this.startNum = startNum;
	}
	@Override
	public void run(){
		int count = 0;
		while(count < 1000000){
			numberList.add(startNum);
			startNum += 2;
			count++;
		}
	}
	public static void main(String[] args) throws Exception{
		Thread t1 = new Thread(new dome(0));
		Thread t2 = new Thread(new dome(1));
		t1.start();
		t2.start();
		while(t1.isAlive()||t2.isAlive()){
			Thread.sleep(1);
		}
		System.out.println(numberList.size());
	}
}