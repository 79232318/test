package com.spring.springboot.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterConfig;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;  
 
@Slf4j
@Component  
public class LogFilter extends OncePerRequestFilter {  
  
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse resp, FilterChain filterChain)
			throws ServletException, IOException {
		MyHttpRequestWrapper request = new MyHttpRequestWrapper(req);
		MyHttpResponseWrapper response = new MyHttpResponseWrapper(resp);
		filterChain.doFilter(request, resp);
		consoleReq(request);

//		consoleResp(response,resp);
		 
    }
	 private void consoleResp(MyHttpResponseWrapper wrapper, HttpServletResponse resp) {
		 
	 }
	 private void consoleReq(MyHttpRequestWrapper request) throws IOException {
		 StringBuffer buffer = new StringBuffer();
	    	buffer.append("请求URL="+request.getRequestURL()).append("\n")
	    	      .append("请求方法="+request.getMethod()).append("\n");
	    	String contentType = request.getContentType();
	    	if(contentType != null) {
	    		buffer.append("请求数据格式="+request.getContentType()).append("\n");
	    	}
	    	buffer.append("请求URI="+request.getRequestURI()).append("\n");
	        Map<String, String[]> map = request.getParameterMap();
	        if(map.size() > 0) {
	        	buffer.append("data="+JSON.toJSONString(map)).append("\n");
	        }
	    	String data = GetRequestJsonUtils.getRequestJsonString(request);
	    	if(!StringUtils.isBlank(data)) {
	    	  	buffer.append("data="+data).append("\n");
	    	}
	    	log.info("\n日志过滤器--------------------------------------------------------\n"+buffer.toString());
	 }
}