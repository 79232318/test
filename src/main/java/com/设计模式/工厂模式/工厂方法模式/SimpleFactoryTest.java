package com.设计模式.工厂模式.工厂方法模式;

import com.设计模式.工厂模式.简单工厂.ICourse;

public class SimpleFactoryTest {
    public static void main(String[] args) {
        ICourseFactory courseFactory = new JavaCourseFactory();
        ICourse course = courseFactory.crete();
        course.record();

        courseFactory = new PythonCourseFactory();
        course = courseFactory.crete();
        course.record();
    }
}