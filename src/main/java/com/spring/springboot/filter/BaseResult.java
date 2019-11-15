package com.spring.springboot.filter;

import java.io.Serializable;

public class BaseResult<T> implements Serializable {


 

	/**  
	* @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	*/  
	private static final long serialVersionUID = 1L;

	private Integer status = 0;

   private String message = null;

   private T data = null;

   public BaseResult(){

   }

   public BaseResult(Integer status, String message, T data) {
       this.status = status;
       this.message = message;
       this.data = data;
   }

   public Integer getStatus() {
       return status;
   }

   public void setStatus(Integer status) {
       this.status = status;
   }

   public String getMessage() {
       return message;
   }

   public void setMessage(String message) {
       this.message = message;
   }

   public T getData() {
       return data;
   }

   public void setData(T data) {
       this.data = data;
   }

   @Override
   public String toString() {
       return "Result{" +
               "status=" + status +
               ", message='" + message + '\'' +
               ", data=" + data +
               '}';
   }
}