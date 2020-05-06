/**  
* @Title: RobotController.java  
* @Package com.钉钉机器人测试  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月30日  
* @version V1.0  
*/  
package com.bingfa;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import com.taobao.api.ApiException;

/**  
* <p>Description: </p>
* @ClassName: RobotController  
* @author wangtz  
* @date 2019年8月30日    
*/
@RestController
public class testController {
	 
	@Autowired
    private Service service;
	@GetMapping("demo")
	public void test() {
		demo demo = new demo();
		service.insert(demo);
	}
	@RequestMapping("demo1")
	public void test1() {
		demo demo = new demo();
		service.insert1(demo);
	}
	@RequestMapping("demo2")
	public void test2() {
		System.out.println("开始测试");
new Thread(new Runnable() {
			
			@Override
			public void run() {
				 
					try {
						service.update1();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				 
				
			}
		},"diyi").start();
        new Thread(new Runnable() {
			
			@Override
			public void run() {
					try {
						service.update3();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		},"dier").start();
	}
}
