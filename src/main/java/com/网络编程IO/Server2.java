package com.网络编程IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//NIO -- 观察者的体现
public class Server2 {
	
	static ExecutorService threadPool = Executors.newCachedThreadPool();
	
	public static void main(String[] args) throws IOException {
	    
		ServerSocketChannel socketChannel = ServerSocketChannel.open(); //默认还是BIO
		socketChannel.configureBlocking(false); //显示的配置非阻塞
		socketChannel.bind(new InetSocketAddress(8080));
		System.out.println("NIO服务启动成功");
		
		
		//jdk -- 底层操作系统 -- 多路复用机制（底层会记录请求的状态）
		//观察者（事件机制）--工具
		Selector selector = Selector.open(); 
		
		while(true) {
			SocketChannel channel  = socketChannel.accept(); //非阻塞 -- 可能返回null
			if(channel == null) {
				continue;
			}
			channel.configureBlocking(false); //显示的配置非阻塞
			
			//BIO是拿到连接直接丢线程池，NIO通过Selector去观察是否有数据，有数据在丢给线程池
			channel.register(selector, SelectionKey.OP_READ);//注册，让Selector帮我们监控新连接 OP_READ 事件
			
			selector.select();
			Set<SelectionKey> eventKeys = selector.selectedKeys();
			Iterator<SelectionKey> it = eventKeys.iterator();
			while(it.hasNext()) {
				SelectionKey event = it.next();
				if(event.isReadable()) {//代表有数据传输过来，可以开启线程了
					threadPool.submit(new Callable<String>() {
						@Override
						public String call() throws Exception {
							SocketChannel connection = (SocketChannel) event.channel();
							ByteBuffer buffer = ByteBuffer.allocate(1024);//TODO 1封装了数组 2其他特性，堆外内存
							connection.read(buffer);
							buffer.flip();//转为读取模式
							System.out.println(new String(buffer.array()));
							return null;
						}
					});
				
				}
			}
		}
	}
}
