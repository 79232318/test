package com.网络编程IO;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//jdk1.0--BIO--java 提供的网络编程的api -- 阻塞
/*
 * 在移动互联时代，连接是很不稳定的，会导致连接被创建，到时阻塞在没有数据那里，线程资源很宝贵，每一个请求都需要一个线程去处理
 * 
 * 
 * */
public class Server1 {
    //线程池
	static ExecutorService threadPool = Executors.newCachedThreadPool();
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		//api限制，一直请求一个连接，不管有没有数据都会创建连接，所以要使用线程池
		while (true) {
			//TODO 主动向操作系统获取一个连接
			Socket socket = serverSocket.accept();//没有连接，线程执行到这个地方 阻塞
			threadPool.submit(new Callable<String>() {

				@Override
				public String call() throws Exception {
					byte[] b = new byte[1024];
					
					socket.getInputStream().read(b);//没有数据。则阻塞
					//TODO 服务器 java应用 -- 收到请求 -- 处理请求
					System.out.println(new String(b));
					return null;
				}
			});
			
		}
	}

}
