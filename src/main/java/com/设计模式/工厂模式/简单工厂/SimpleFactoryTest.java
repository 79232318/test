package com.设计模式.工厂模式.简单工厂;

public class SimpleFactoryTest {
    public static void main(String[] args) {
//        ICourse course = new JavaCourse();
//    	ICourse course = CourseFactory.create("java");
//    	 ICourse course = CourseFactory.createReflect("com.设计模式.工厂模式.简单工厂.JavaCourse");
    	ICourse course = CourseFactory.createReflect(JavaCourse.class);
        course.record();
    }
}