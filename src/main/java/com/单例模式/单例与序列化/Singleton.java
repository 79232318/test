//code 11
package com.单例模式.单例与序列化;
import java.io.Serializable;

/**
 * Created by hollis on 16/2/5.
 * 使用双重校验锁方式实现单例
 */
public class Singleton implements Serializable{
    private volatile static Singleton singleton;
    private Singleton (){}
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
//要想防止序列化对单例的破坏，只要在Singleton类中定义readResolve就可以解决该问题：
    private Object readResolve() {
        return singleton;
    }
    public static void main(String[] args) {
    	
    	Singleton simpleSingleton1 = Singleton.getSingleton();
    	for (int i = 0; i < 100; i++) {
			
    		Singleton simpleSingleton2 = Singleton.getSingleton();
    		if(simpleSingleton1!=simpleSingleton2) {
    			
    			System.out.println("false");
    		}
		}
    	
    }
}