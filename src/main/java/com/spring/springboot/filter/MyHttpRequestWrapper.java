/**  
* @Title: MyHttpRequestWrapper.java  
* @Package com.过滤器加日志  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月15日  
* @version V1.0  
*/  
package com.spring.springboot.filter;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import org.slf4j.Logger;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

/**  
* <p>Description: </p>
* @ClassName: MyHttpRequestWrapper  
* @author wangtz  
* @date 2019年10月15日    
*/
@Slf4j
public class MyHttpRequestWrapper extends HttpServletRequestWrapper {

	private byte[] requestBody=null;//用于将流保存下来

	/**  
	* 创建一个新的实例 MyHttpRequestWrapper.  
	*  
	* @param request  
	*/  
	public MyHttpRequestWrapper(HttpServletRequest request) {
		super(request);
		try {
			requestBody = StreamUtils.copyToByteArray(request.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		if(requestBody == null) {
			requestBody = new byte[0];
		}
		final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(requestBody);
		
		return new ServletInputStream() {
			
			@Override
			public int read() throws IOException {
				return byteArrayInputStream.read();//返回复制的流
			}
			
			@Override
			public void setReadListener(ReadListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isReady() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isFinished() {
				// TODO Auto-generated method stub
				return false;
			}
		};
	}

	@Override
	public BufferedReader getReader() throws IOException {
		// TODO Auto-generated method stub
		return new BufferedReader(new InputStreamReader(getInputStream(), Charset.forName("UTF-8")));
	}
	

}
