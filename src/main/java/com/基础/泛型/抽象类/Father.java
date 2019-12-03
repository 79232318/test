package com.基础.泛型.抽象类;
/**
 * 泛型父类：子类为“富二代”：子类的泛型要比父类多
 * 1，保留父类的泛型-->子类为泛型类
 * 2，不保留父类泛型-->子类按需实现
 * 
 * 
 * 子类【重写方法】的参数类型 -->随父类而定
 *     子类新增的方法，参数类型随子类而定
 * 子类中使用父类的【属性】 -->随父类而定
 *         子类使用自己的属性-->随子类而定
 * @author Administrator
 *
 */
public abstract  class Father<T1,T2> {
        T1 age ;
        public abstract void test(T2 name);
}

//当继承Father类时，T1、T2的处理方式：

//保留 -->父类保留，子类必须保留，所以子类是泛型子类     
//1) 全部保留
class C1<T2,T1,A> extends Father<T1,T2>{
    
    @Override
    public void test(T2 name) {//子类重写方法的参数类型 -->随父类而定：T2    
        System.out.println("name : "+name);
    }
    
    //子类自定义属性，类型随子类
    A a ;
    String str ;
    /**
     * 子类新增的方法，参数类型随子类而定
     * @param a
     */
    public void test2(A a){
        System.out.println(a);
//        this.a --> A类型，随子类
    }
}

//2) 部分保留
class C2<T2> extends Father<Integer,T2>{

    @Override
    public void test(T2 name) {//子类重写方法的参数类型 -->随父类而定：T2    
        this.age = 23; //Integer类型，子类使用父类的【属性】，类型随父类而定
    }
}

//不保留，把T1、T2替换成具体的类型 
//---》按需实现:子类 可以扩展泛型
//1) 具体类型
class C3<A,B> extends Father<String,Integer>{

    @Override
    public void test(Integer name) {//子类重写方法的参数类型 -->随父类而定：Integer
        this.age = "24";//String 类型，子类使用父类的【属性】，类型随父类而定
    }
}

//2) 没有类型 擦除 --》Object
class C4<A,B> extends Father{

    @Override
    public void test(Object name) {//子类重写方法的参数类型 -->随父类而定：Object
        this.age = new Object();//Object 类型，子类使用父类的【属性】，类型随父类而定
    }
}