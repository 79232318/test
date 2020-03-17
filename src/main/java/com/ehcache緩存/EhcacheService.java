/**  
* @Title: EhcacheService.java  
* @Package com.ehcache緩存  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年12月9日  
* @version V1.0  
*/  
package com.ehcache緩存;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ehcache緩存.entity.User;

/**  
* <p>Description: </p>
* @ClassName: EhcacheService  
* @author wangtz  
* @date 2019年12月9日    
*/
@Service
public class EhcacheService {

	@Autowired
	UserRepository userRepository;

	@UserSaveCachePut
	public User saveAndflush(User user){
		return userRepository.saveAndFlush(user);
	}
	
 
	@CacheEvict(value = "users", key = "#userId")//方法参数时我们可以直接使用“#参数名”或者“#p参数index”
	public void del(Long id, String userId){
		 userRepository.deleteById(id);
	}
    

	/**
	 * 
	 * <p>Title:findByUserId</p>
	 * <p>Description: </p>
	 *  @param userId
	 *  @return
	 */
	public User findByUserId(String userId) {
		return userRepository.findByUserId(userId);
	}


	/**
	 * 
	 * <p>Title:findId</p>
	 * <p>Description: </p>
	 *  @param id
	 *  @return
	 */
	@Cacheable(value="users",key="#id")
	public User findId(Long id) {
		Optional<User> optional =userRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
}
