package com.设计模式.工厂模式.简单工厂;

public class CourseFactory {
    public static ICourse create(String name){
        if("java".equals(name)){
            return new JavaCourse();
        }else if("python".equals(name)){
            return new PythonCourse();
        }else {
            return null;
        }
        
    }
    public static ICourse createReflect(String className){
        //这里没有引入springUtil相关的jar包,也没有自己封装,将就吧
        if(className != null && !"".equals(className)){
            try {
                return (ICourse) Class.forName(className).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public static ICourse createReflect(Class<? extends ICourse> clazz){
        if(clazz != null){
            try {
                return clazz.newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}