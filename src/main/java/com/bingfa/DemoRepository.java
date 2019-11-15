/**  
* @Title: DemoRepository.java  
* @Package com.bingfa  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月30日  
* @version V1.0  
*/  
package com.bingfa;

import org.springframework.data.jpa.repository.JpaRepository;

/**  
* <p>Description: </p>
* @ClassName: DemoRepository  
* @author wangtz  
* @date 2019年8月30日    
*/
public interface DemoRepository extends JpaRepository<demo, Long>{

}
