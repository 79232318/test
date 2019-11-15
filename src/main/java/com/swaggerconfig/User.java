/**  
* @Title: User.java  
* @Package com.swaggerconfig  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年10月14日  
* @version V1.0  
*/  
package com.swaggerconfig;

import io.swagger.annotations.ApiParam;
import lombok.Data;

/**  
* <p>Description: </p>
* @ClassName: User  
* @author wangtz  
* @date 2019年10月14日    
*/
@Data
public class User {
	@ApiParam(defaultValue = "1")
   private Long id;
   private String name;
   private Integer age;
   
}
