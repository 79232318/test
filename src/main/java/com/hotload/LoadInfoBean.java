package com.hotload;

import lombok.Data;

/**
 * 
* <p>Description: 封装加载类的信息</p>
* @ClassName: LoadInfo  
* @author wangtz  
* @date 2019年12月11日
 */
@Data
public class LoadInfoBean {

    /** 自定义的类加载器 */
    private MyClassLoader myClasslLoader;

    /** 记录要加载的类的时间戳-->加载的时间 */
    private long loadTime;

    /** 需要被热加载的类 */
    private BaseManager manager;

    private String name;
    
    public LoadInfoBean(MyClassLoader myClasslLoader, long loadTime) {
        this.myClasslLoader = myClasslLoader;
        this.loadTime = loadTime;
    }

    public MyClassLoader getMyClasslLoader() {
        return myClasslLoader;
    }

    public void setMyClasslLoader(MyClassLoader myClasslLoader) {
        this.myClasslLoader = myClasslLoader;
    }

    public long getLoadTime() {
        return loadTime;
    }

    public void setLoadTime(long loadTime) {
        this.loadTime = loadTime;
    }

    public BaseManager getManager() {
        return manager;
    }

    public void setManager(BaseManager manager) {
        this.manager = manager;
    }
}