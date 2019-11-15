package com.单例模式.懒汉式.双重校验锁;
//code 7
/**
 * 针对上面code 6存在的问题，相信对并发编程了解的同学都知道如何解决。
 * 其实上面的代码存在的问题主要是锁的范围太大了。
 * 只要缩小锁的范围就可以了。
 * 那么如何缩小锁的范围呢？相比于同步方法，同步代码块的加锁范围更小。code 6可以改造成
 */
public class Singleton {

    private static Singleton singleton;

    private Singleton() {
    }

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
}