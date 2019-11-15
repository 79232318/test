/**  
* @Title: demo.java  
* @Package com.bingfa  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月30日  
* @version V1.0  
*/  
package com.bingfa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

/**  
* <p>Description: </p>
* @ClassName: demo  
* @author wangtz  
* @date 2019年8月30日    
*/
@Data
@Entity
public class demo {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private Integer age;
	
//	@Version
//    private Integer version;
}
