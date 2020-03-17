/**  
* @Title: UserSaveCachePut.java  
* @Package com.ehcache緩存  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年12月9日  
* @version V1.0  
*/  
package com.ehcache緩存;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Caching;

/**  
* <p>Description: </p>
* @ClassName: UserSaveCachePut  
* @author wangtz  
* @date 2019年12月9日    
*/
@Caching( put= {
		@CachePut(value = "users", key = "#result.userId"),
		@CachePut(value = "users", key = "#result.id")
})
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface UserSaveCachePut {

}
