package com.java8新特性.函数式接口.实例;
/**
 * 提醒：加不加 @FunctionalInterface 对于接口是不是函数式接口没有影响，该注解只是提醒编译器去检查该接口是否仅包含一个抽象方法
 */
@FunctionalInterface
interface GreetingService
{
    void sayMessage(String message);
    //void sayMessage1(String message);

    /**
     * * 函数式接口里允许定义默认方法
	 * * 函数式接口里是可以包含默认方法，因为默认方法不是抽象方法，其有一个默认实现，所以是符合函数式接口的定义的；
     */
    default void doSomeMoreWork1()
    {
        // Method body
    }
    default void doSomeMoreWork2()
    {
        // Method body
    }
    /**
     ** 函数式接口里允许定义静态方法
     ** 函数式接口里是可以包含静态方法，因为静态方法不能是抽象方法，是一个已经实现了的方法，所以是符合函数式接口的定义的；
     */
    static void printHello(){
        System.out.println("Hello");
    }
	/**
	 ** 函数式接口里允许定义 java.lang.Object 里的 public 方法
	 ** 函数式接口里是可以包含Object里的public方法，这些方法对于函数式接口来说，不被当成是抽象方法（虽然它们是抽象方法）；
	 ** 因为任何一个函数式接口的实现，默认都继承了 Object 类，包含了来自 java.lang.Object 里对这些抽象方法的实现
	 */
    @Override
    boolean equals(Object obj);
}