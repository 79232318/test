package com.hotload;

import java.time.LocalTime;
/**
 * 
* <p>Description: BaseManager 这个接口的子类要实现类的热加载功能。</p>
* @ClassName: MyManager  
* @author wangtz  
* @date 2019年12月11日
 */
public class MyManager implements BaseManager {

    @Override
    public void logic() {
        System.out.println(LocalTime.now() + ": Java类 的 热 加  载     ");
    }
}