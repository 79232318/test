/**  
* @Title: DemoDao.java  
* @Package com.mybatis分页  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年9月23日  
* @version V1.0  
*/  
package com.mybatis分页;

import java.util.List;

import com.bingfa.demo;

/**  
* <p>Description: </p>
* @ClassName: DemoDao  
* @author wangtz  
* @date 2019年9月23日    
*/

public interface DemoDao {

	List<demo> findAll();
}
