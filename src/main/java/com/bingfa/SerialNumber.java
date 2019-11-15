 package com.bingfa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import lombok.Data;

/**  
* <p>Description: </p>
* @ClassName: SerialNumber  
* @author wangtz  
* @date 2019年6月10日    
*/
@Entity
@Data
public class SerialNumber {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Integer number;
	
	private String date;
	
	private String status;
	
//	@Version
//	private int version;
}
