package com.单例模式.懒汉式.线程安全的懒汉式;
//code 6
/*这种写法能够在多线程中很好的工作，
 * 而且看起来它也具备很好的延迟加载，但是，遗憾的是，他效率很低，因为99%情况下不需要同步。
 * （因为上面的synchronized的加锁范围是整个方法，该方法的所有操作都是同步进行的，但是对于非第一次创建对象的情况，
 * 也就是没有进入if语句中的情况，根本不需要同步操作，可以直接返回instance。）
*/
public class SynchronizedSingleton {
    //定义实例
    private static SynchronizedSingleton instance;
    //私有构造方法
    private SynchronizedSingleton(){}
    //对外提供获取实例的静态方法,对该方法加锁
    public static synchronized SynchronizedSingleton getInstance() {
        //在对象被使用的时候才实例化
        if (instance == null) {
            instance = new SynchronizedSingleton();
        }
        return instance;
    }
}