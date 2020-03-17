/**  
* @Title: MyClassLoader.java  
* @Package com.热加载  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年12月11日  
* @version V1.0  
*/  
package com.hotload;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**  
* <p>Description:  自定义 Java类加载器来实现Java 类的热加载</p>
* @ClassName: MyClassLoader  
* @author wangtz  
* @date 2019年12月11日    
*/
public class MyClassLoader extends ClassLoader {
	
	private static final String CLASS_FILE_SUFFIX = ".class";
	/** 要加载的 Java 类的 classpath 路径 */
	private String classpath;

	 //AppClassLoader的父类加载器
    private ClassLoader extClassLoader;

    public MyClassLoader(){
        ClassLoader j = String.class.getClassLoader();
        System.out.println(j);
        if (j == null) {
        	//AppClassLoader 可以由 ClassLoader 类提供的静态方法 getSystemClassLoader() 称为系统类加载器
            j = getSystemClassLoader();
            while (j.getParent() != null) {
                j = j.getParent();
            }
        }
        this.extClassLoader = j ;
    }
    
	public MyClassLoader(String classpath) {
		 // 指定父加载器
		super(ClassLoader.getSystemClassLoader());
		this.classpath = classpath;
	}
	 // 加载入口，定义了双亲委派规则
	 protected Class<?> loadClass(String name, boolean resolve){

	        Class<?> cls = null;
	        //检查该类是否已经加载了 
	        cls = findLoadedClass(name);
	        if (cls != null){
	            return cls;
	        }
	        
	        //获取ExtClassLoader
	        ClassLoader extClassLoader = getExtClassLoader() ;
	        //确保自定义的类不会覆盖Java的核心类
	        try {
	            cls = extClassLoader.loadClass(name);
	            if (cls != null){
	                return cls;
	            }
	        }catch (ClassNotFoundException e ){

	        }
	        cls = findClass(name);
	        return cls;
	    }

	 
    /**
     *  所以如果我们想要自己实现一个类加载器，就需要继承 ClassLoader 然后重写里面 findClass的方法，
     *  同时因为类加载器是 双亲委派模型实现，所以我们还需要指定父加载器。
     */
	@Override
	protected Class<?> findClass(String name) {
		System.out.println("自己加载");
		byte[] data = this.loadClassData(name);
		//将你定义的字节码文件经过字节数组流解密之后，将该字节流数组生成字节码文件，也就是该类的文件的类名.class。
        return this.defineClass(name, data, 0, data.length);
	}
	
	/**
     * 加载 class 文件中的内容
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        try {
            // 传进来是带包名的
//            name = name.replace(".", "//");
//            通过一个类的全限定名来获取描述此类的二进制字节流
//            FileInputStream inputStream = new FileInputStream(new File(classpath + name + ".class"));
        	// 读取Class文件呢
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(name.replace(".", "/") + CLASS_FILE_SUFFIX);
            // 定义字节数组输出流
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;
            while ((b = inputStream.read()) != -1) {
                baos.write(b);
            }
            inputStream.close();
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
	
    public ClassLoader getExtClassLoader(){
        return extClassLoader;
    }

}
