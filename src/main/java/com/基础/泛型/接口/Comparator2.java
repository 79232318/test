package com.基础.泛型.接口;
/**
 * 泛型接口：与泛型类 同理
 * @author Administrator
 *
 * @param <T>
 */
public interface Comparator2<T> {
    //全局常量
    public static final int MAX_VALUE =100;
    //公共抽象方法
    public abstract void test(T t);
}
//实现
class InterC1<A> implements Comparator2{
	@Override
	public void test(Object t) {//类型是父类的
		System.out.println(MAX_VALUE); //父类的  
	}
    
}
class InterC2 implements Comparator2<Integer>{
    @Override
    public void test(Integer t) { //类型是父类的
        
    }
}

class InterC3<T,A> implements Comparator2<T>{
    @Override
    public void test(T t) {//类型是父类的
        
    }
}