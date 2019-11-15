package com.设计原则.依赖倒置原则.满足依赖倒置原则;
/**
 * 构造器使用方式并不是非常方便 需要拓展的时候 还有new一个出来Buy实现类
在Spring框架中默认的设计模式是 单例模式
之前是构造器方式
现在取消构造器方式 改用Setter方法
修改Buy类
 */
public class Buy {


    private Things things;

    public void setThings(Things things) {
        this.things = things;
    }

    public void buy(){
        things.buyThins();
    }
}
