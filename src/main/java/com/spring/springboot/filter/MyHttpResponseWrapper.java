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
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.slf4j.Logger;
import org.springframework.util.StreamUtils;

import lombok.extern.slf4j.Slf4j;

/**  
 * 主要使用的是apache提供的TeeOutputStream类将输出流复制一份出来
* <p>Description: </p>
* @ClassName: MyHttpRequestWrapper  
* @author wangtz  
* @date 2019年10月15日    
*/
@Slf4j
public class MyHttpResponseWrapper extends HttpServletResponseWrapper {


    private ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    private HttpServletResponse response;
    private PrintWriter pwrite;

    public MyHttpResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return new MyServletOutputStream(bytes); // 将数据写到 byte 中
    }

    /**
     * 重写父类的 getWriter() 方法，将响应数据缓存在 PrintWriter 中
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        try{
            pwrite = new PrintWriter(new OutputStreamWriter(bytes, "utf-8"));
        } catch(UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return pwrite;
    }

    /**
     * 获取缓存在 PrintWriter 中的响应数据
     * @return
     */
    public byte[] getBytes() {
        if(null != pwrite) {
            pwrite.close();
            return bytes.toByteArray();
        }

        if(null != bytes) {
            try {
                bytes.flush();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return bytes.toByteArray();
    }

    class MyServletOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream ostream ;

        public MyServletOutputStream(ByteArrayOutputStream ostream) {
            this.ostream = ostream;
        }

        @Override
        public void write(int b) throws IOException {
            ostream.write(b); // 将数据写到 stream　中
        }

		/**
		* <p>Title: isReady</p>  
		* <p>Description: </p>  
		* @return  
		* @see javax.servlet.ServletOutputStream#isReady()  
		*/  
		@Override
		public boolean isReady() {
			// TODO Auto-generated method stub
			return false;
		}

		/**
		* <p>Title: setWriteListener</p>  
		* <p>Description: </p>  
		* @param listener  
		* @see javax.servlet.ServletOutputStream#setWriteListener(javax.servlet.WriteListener)  
		*/  
		@Override
		public void setWriteListener(WriteListener listener) {
			// TODO Auto-generated method stub
			
		}

    }

}
