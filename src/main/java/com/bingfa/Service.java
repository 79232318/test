/**  
* @Title: Service.java  
* @Package com.bingfa  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月30日  
* @version V1.0  
*/  
package com.bingfa;

import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;



/**  
* <p>Description: </p>
* @ClassName: Service  
* @author wangtz  
* @date 2019年8月30日    
*/
@org.springframework.stereotype.Service
public class Service {
    final static Object o = new Object();
	@Autowired
	private DemoRepository demoRepository;
	
	@Transactional
	public void update1() throws InterruptedException  {
		
		int i = demoRepository.update();
		System.out.println(Thread.currentThread().getName() + "的i为"+i);
		System.out.println("休息10s");
		Thread.sleep(1000*10);
		if(i > 0) {
			List<demo> list  = demoRepository.findAlll();
			System.out.println(Thread.currentThread().getName() + "的list为"+list);
		}
	}
	@Transactional
	public void update3() throws InterruptedException  {
		
		int i = demoRepository.update();
		System.out.println(Thread.currentThread().getName() + "的i为"+i);
		System.out.println("休息10s");
		Thread.sleep(1000*10);
		if(i > 0) {
			List<demo> list  = demoRepository.findAlll();
			System.out.println(Thread.currentThread().getName() + "的list为"+list);
		}
	}
	@Transactional
	public void update2(){
//		demo d = demoRepository.findById(2L).get();
//		d.setName("ssxcsd");
//		demoRepository.save(d);
//		System.out.println(d.toString());
		demo demo = demoRepository.findById(1L).get();
		 
			System.out.println("我的年龄是"+demo.getAge()+"岁，我将要年轻一岁");
			demo.setAge(demo.getAge() - 1);
			
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			demoRepository.save(demo);
			System.out.println("我现在年轻了"+demo.getAge()+"岁");
			System.out.println(demo.toString());
			demo demo1 = demoRepository.findById(2L).get();
			demo1.setAge(demo1.getAge() - 1);
			demoRepository.save(demo1);
			
		 
	}
	 @Autowired
	 private JpaTransactionManager tm;
	 @Autowired
	 private  SerialNumberRepository serialNumberRepository;
	public synchronized void insert(demo demo)  {
		//事务开始
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);  
		def.setTimeout(30);
		
		//事务状态
		TransactionStatus status = tm.getTransaction(def); 
		try {
			createSerialNumber(demo);
//			System.out.println("我要睡10s");
//			Thread.sleep(1000*10);
			System.out.println(demo);
			demoRepository.save(demo);
			if(demo.getName().contains("80")) {
				
				int i = 7/0;
			}
			tm.commit(status);
		} catch (Exception e) {
			System.out.println("huigun");
			
			return ;
		}finally {
			System.out.println("close");
			if(!status.isCompleted()) {
				tm.rollback(status);
		    }
		 
		}
		
	}
	
	public synchronized void insert1(demo demo)  {
		//事务开始
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);  
		def.setTimeout(30);
		
		//事务状态
		TransactionStatus status = tm.getTransaction(def); 
		try {
			createSerialNumber(demo);
//			if(demo.getName().contains("80")) {
//			}
			System.out.println(demo);
			demoRepository.save(demo);
if(demo.getName().contains("80")) {
				
				int i = 7/0;
			}
			tm.commit(status);
		} catch (Exception e) {
			System.out.println("huigun="+status.isCompleted());
//			
			return ;
		}finally {
			
			System.out.println("close="+status.isCompleted());
			if(!status.isCompleted()) {
				tm.rollback(status);
		    } 
		 
		}
		
	}
	 
    public  void createSerialNumber(demo demo) {
		
		
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
		String date=sdf.format(new Date());
		String status="As";
		SerialNumber serialNumber=serialNumberRepository.findByDateAndStatus(date,status);
		System.out.println(Thread.currentThread().getName()+serialNumber);
		if(serialNumber == null) {
			System.out.println(Thread.currentThread().getName()+serialNumber);
			serialNumber=new SerialNumber();
			serialNumber.setDate(date);
			serialNumber.setNumber(0);
			serialNumber.setStatus("As");
		}
		//计算4位自增
		int num=serialNumber.getNumber()+1;
		serialNumber.setNumber(num);
		
		serialNumberRepository.save(serialNumber);
		String s=num+"";
		int length=4-s.length();
		for (int j= 1 ; j<=length; j++) {
				s=0+s;
		}
		demo.setName(serialNumber.getStatus()+serialNumber.getDate()+s);
}
	 
}
