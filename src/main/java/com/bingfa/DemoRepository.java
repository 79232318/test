/**  
* @Title: DemoRepository.java  
* @Package com.bingfa  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年8月30日  
* @version V1.0  
*/  
package com.bingfa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**  
* <p>Description: </p>
* @ClassName: DemoRepository  
* @author wangtz  
* @date 2019年8月30日    
*/
public interface DemoRepository extends JpaRepository<demo, Long>{

	@Modifying
	@Query(value = "update demo set age  = 5 where age = 1",nativeQuery = true)
	int update();
	@Query(value = "select * from demo where age = 5",nativeQuery = true)
	List<demo> findAlll();

}
