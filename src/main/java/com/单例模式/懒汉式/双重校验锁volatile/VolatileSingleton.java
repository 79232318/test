package com.单例模式.懒汉式.双重校验锁volatile;
//code 8

public class VolatileSingleton {
    private static volatile VolatileSingleton singleton;

    private VolatileSingleton() {
    }

    public static VolatileSingleton getSingleton() {
        if (singleton == null) {
            synchronized (VolatileSingleton.class) {
                if (singleton == null) {
                    singleton = new VolatileSingleton();
                }
            }
        }
        return singleton;
    }
}
/*但是，事情这的有这么容易吗？上面的代码看上去好像是没有任何问题。实现了惰性初始化，解决了同步问题，还减小了锁的范围，提高了效率。但是，该代码还存在隐患。隐患的原因主要和Java内存模型（JMM）有关。考虑下面的事件序列：

线程A发现变量没有被初始化, 然后它获取锁并开始变量的初始化。

由于某些编程语言的语义，编译器生成的代码允许在线程A执行完变量的初始化之前，更新变量并将其指向部分初始化的对象。

线程B发现共享变量已经被初始化，并返回变量。由于线程B确信变量已被初始化，它没有获取锁。如果在A完成初始化之前共享变量对B可见（这是由于A没有完成初始化或者因为一些初始化的值还没有穿过B使用的内存(缓存一致性)），程序很可能会崩溃。

（上面的例子不太能理解的同学，请恶补JAVA内存模型相关知识）

在J2SE 1.4或更早的版本中使用双重检查锁有潜在的危险，有时会正常工作（区分正确实现和有小问题的实现是很困难的。取决于编译器，线程的调度和其他并发系统活动，不正确的实现双重检查锁导致的异常结果可能会间歇性出现。重现异常是十分困难的。） 在J2SE 5.0中，这一问题被修正了。volatile关键字保证多个线程可以正确处理单件实例

所以，针对code 7 ，可以有code 8 和code 9两种替代方案：

使用volatile*/