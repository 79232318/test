package com.hotload.钻石依赖;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;


public class Test {
    public static void main(String[] args) throws Exception {
        String v1dir = "http://120.79.128.13/image/v1/";
        String v2dir = "http://120.79.128.13/image/v2/";
//        URLClassLoader v1 = new URLClassLoader(new URL[]{new File("E:\\eclipseworkspace64\\practice\\target\\classes\\com\\hotload\\钻石依赖\\v1").toURI().toURL()});
        URLClassLoader v1 = new URLClassLoader(new URL[]{new URL(v1dir)});
        URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(v2dir)});
 
        Class<?> depv1Class = v1.loadClass("Dep");
        Object depv1 = depv1Class.getConstructor().newInstance();
        depv1Class.getMethod("print").invoke(depv1);

        Class<?> depv2Class = v2.loadClass("Dep");
        Object depv2 = depv2Class.getConstructor().newInstance();
        depv2Class.getMethod("print").invoke(depv2);

        System.out.println(depv1Class.equals(depv2Class));
   }
}