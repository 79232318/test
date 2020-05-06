package com.cas.自旋;

public class test {

	public static void main(String[] args) throws InterruptedException {
		final Counter count = new CounterBasic();
		for (int i = 0; i < 2; i++) {
			new Thread(()->{
				for (int j = 0; j < 1000; j++) {
					count.incr();
				}
			}).start();
		}
		
		Thread.sleep(6000L);
		System.out.println("计算结果"+ count.get());
	}

}
