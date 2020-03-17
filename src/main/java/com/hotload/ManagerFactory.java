package com.hotload;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
/**
 * 
* <p>Description:加载 manager 的工厂 </p>
* @ClassName: ManagerFactory  
* @author wangtz  
* @date 2019年12月11日
 */
public class ManagerFactory {

    /** 记录热加载类的加载信息 */
    private static final Map<String, LoadInfoBean> loadTimeMap = new HashMap<>();

    /** 要加载的类的 classpath */
    public static final String CLASS_PATH = "E:\\eclipseworkspace64\\practice\\target\\classes\\";

    /** 实现热加载的类的全名称(包名+类名 ) */
    public static final String MY_MANAGER = "com.hotload.MyManager";
 
    public static void getManager(String className) {
        File loadFile = new File(CLASS_PATH + className.replaceAll("\\.", "/") + ".class");
        // 获取最后一次修改时间
        long lastModified = loadFile.lastModified();
        System.out.println("当前类的时间：" + lastModified);
        // loadTimeMap 不包含 ClassName 为 key 的信息，证明这个类没有被加载，要加载到 JVM
        if (loadTimeMap.get(className) == null) {
            load(className, lastModified);
        } // 加载类的时间戳变化了，我们同样要重新加载这个类到 JVM。
        else if (loadTimeMap.get(className).getLoadTime() != lastModified) {
            load(className, lastModified);
        }
    }

    /**
     * 加载 class ，缓存到 loadTimeMap
     * 
     * @param className
     * @param lastModified
     */
    private static void load(String className, long lastModified) {
        MyClassLoader myClasslLoader = new MyClassLoader();
        Class<?> cls = null;
        // 加载
        try {
        	//根据className查找并加载类。先在parent或bootstrap中查找，有则给jvm加载。没有则按照findClass方法查找
        	cls = myClasslLoader.loadClass(className, false);
        	Object test = cls.newInstance();
        	Method method = cls.getMethod("logic");
        	method.invoke(test);
        	LoadInfoBean loadInfo = new LoadInfoBean(myClasslLoader, lastModified);
        	loadTimeMap.put(className, loadInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        //记录
    }

    /**
     * 以反射的方式创建 BaseManager 的子类对象---无用
     * 
     * @param loadClass
     * @return
     */
    private static BaseManager newInstance(Class loadClass) {
        try {
        	//如果不想要把class加载到jvm中，也可以单独使用getConstructor和newInstance来实例化一个对象。
            return (BaseManager)loadClass.getConstructor(new Class[] {}).newInstance(new Object[] {});
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}