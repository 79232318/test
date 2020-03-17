package com.spring.springboot.peizhi;
/**  
* @Title: TestProperties.java  
* @Package com.spring.springboot.peizhi  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2020年3月11日  
* @version V1.0  
*/ 

import org.springframework.boot.context.properties.ConfigurationProperties;

/**  
* <p>Description: </p>
* @ClassName: TestProperties  
* @author wangtz  
* @date 2020年3月11日    
*/
@ConfigurationProperties(prefix = TestProperties.MY_P )
public class TestProperties {

	public final static String MY_P = "mypro";
	
	private String myName;

	public String getMyName() {
		return myName;
	}

	public void setMyName(String myName) {
		this.myName = myName;
	}
	
	
}
