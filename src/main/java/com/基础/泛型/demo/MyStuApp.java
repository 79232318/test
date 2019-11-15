package com.基础.泛型.demo;
/**
 * 泛型的擦除：使用时 实现|继承  没有指定具体的类型
 * 类似于Object 不等同于Object
 * @author Administrator
 *
 */
public class MyStuApp {

    public static void main(String[] args) {
        //擦除：没有指定泛型的具体类型
        //泛型擦除，但是存在警告
        MyStudent student = new MyStudent();
        student.setJavase(100); //int-->Object,以Object处理
        Object javase = student.getJavase();
        
        //2、消除警告 使用 Object
        MyStudent<Object> student2 = new MyStudent<Object>();
        
        //正确:  擦除，编译通过，不会类型检查
        test(student);
        
        //编译失败：MyStudent<Object> 不等同于Object
        //错误 ，Object 编译检查
        //test(student2);
    }
    
    public static void test(MyStudent<Integer> stu){
        
    }
}