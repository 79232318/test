package com.java8新特性.方法引用;

import java.util.Arrays;
import java.util.List;


 
public class Carc {
	@FunctionalInterface
	interface Supplier<T> {
	    T get();
	}
    //Supplier是jdk1.8的接口，这里和lamda一起使用了
    public static Carc create(final Supplier<Carc> supplier) {
        return supplier.get();
    }
 
    public static void collide(final Carc car) {
        System.out.println("Collided " + car.toString());
    }
 
    public void follow(final Carc another) {
        System.out.println("Following the " + another.toString());
    }
 
    public void repair() {
        System.out.println("Repaired " + this.toString());
    }
    public static void main(String[] args) {
    	//构造器引用：它的语法是Class::new，或者更一般的Class< T >::new实例如下：

    	final Carc car = Carc.create( Carc::new );
    	final List< Carc > cars = Arrays.asList( car );
    	//静态方法引用：它的语法是Class::static_method，实例如下：

    	cars.stream().forEach( Carc::collide );
    	//特定类的任意对象的方法引用：它的语法是Class::method实例如下：

    	cars.forEach( Carc::repair );
    	//特定对象的方法引用：它的语法是instance::method实例如下：

    	final Carc police = Carc.create( Carc::new );
    	cars.forEach( police::follow );
	}
}