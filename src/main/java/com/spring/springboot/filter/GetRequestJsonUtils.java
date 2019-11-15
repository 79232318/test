package com.spring.springboot.filter;
 
import java.io.IOException;
 
import javax.servlet.http.HttpServletRequest;
 
import com.alibaba.fastjson.JSONObject;
 
public class GetRequestJsonUtils {
	
	public static JSONObject getRequestJsonObject(HttpServletRequest request) throws IOException {
		String json = getRequestJsonString(request);
		return JSONObject.parseObject(json);
	}
	 /***
     * 获取 request 中 json 字符串的内容
     * 
     * @param request
     * @return : <code>byte[]</code>
     * @throws IOException
     */
    public static String getRequestJsonString(HttpServletRequest request)
            throws IOException {
        String submitMehtod = request.getMethod();
        // GET
        if (submitMehtod.equals("GET")) {
        	if(request.getQueryString() == null) {
        		return null;
        	}
            return new String(request.getQueryString().getBytes("iso-8859-1"),"utf-8").replaceAll("%22", "\"");
        // POST
        } else if(submitMehtod.equals("POST") || submitMehtod.equals("PUT")){
            return getRequestPostStr(request);
        } else {
        	return null;
        }
		
    }
 
    /**      
     * 描述:获取 post 请求的 byte[] 数组
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static byte[] getRequestPostBytes(HttpServletRequest request)
            throws IOException {
        int contentLength = request.getContentLength();
        if(contentLength<0){
            return null;
        }
        byte buffer[] = new byte[contentLength];
//        while(request.getInputStream().readLine(buffer, 0, contentLength) != -1) {
//        	
//        }
        for (int i = 0; i < contentLength;) {
 
            int readlen = request.getInputStream().read(buffer, i,
                    contentLength - i);
            if (readlen == -1) {
                break;
            }
            i += readlen;
        }
        return buffer;
    }
 
    /**      
     * 描述:获取 post 请求内容
     * <pre>
     * 举例：
     * </pre>
     * @param request
     * @return
     * @throws IOException      
     */
    public static String getRequestPostStr(HttpServletRequest request)
            throws IOException {
        byte buffer[] = getRequestPostBytes(request);
        String charEncoding = request.getCharacterEncoding();
        if (charEncoding == null) {
            charEncoding = "UTF-8";
        }
        return new String(buffer, charEncoding);
    }
 
}