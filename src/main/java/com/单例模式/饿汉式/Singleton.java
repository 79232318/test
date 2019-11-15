package com.单例模式.饿汉式;
//code 1
/*code 1就是一个简单的单例的实现，这种实现方式我们称之为饿汉式。
 * 所谓饿汉。这是个比较形象的比喻。
 * 对于一个饿汉来说，他希望他想要用到这个实例的时候就能够立即拿到，而不需要任何等待时间。
 * 所以，通过static的静态初始化方式，在该类第一次被加载的时候，就有一个SimpleSingleton的实例被创建出来了。
 * 这样就保证在第一次想要使用该对象时，他已经被初始化好了。
  *同时，由于该实例在类被加载的时候就创建出来了，所以也避免了线程安全问题。*/
public class Singleton {
    //在类内部实例化一个实例
    private static Singleton instance = new Singleton();
    //私有的构造函数,外部无法访问
    private Singleton() {
    }
    //对外提供获取实例的静态方法
    public static Singleton getInstance() {
        return instance;
    }
    public static void main(String[] args) {
    	Singleton simpleSingleton1 = Singleton.getInstance();
    	Singleton simpleSingleton2 = Singleton.getInstance();
        System.out.println(simpleSingleton1==simpleSingleton2);
    }
}