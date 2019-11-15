package com.设计模式.工厂模式.工厂方法模式;

import com.设计模式.工厂模式.简单工厂.ICourse;
import com.设计模式.工厂模式.简单工厂.JavaCourse;

public class JavaCourseFactory implements ICourseFactory {
    @Override
    public ICourse crete() {
        return new JavaCourse();
    }
}