/**  
* @Title: EhcacheController.java  
* @Package com.ehcache緩存  
* @Description: TODO(用一句话描述该文件做什么)  
* @author wangtz  
* @date 2019年12月9日  
* @version V1.0  
*/  
package com.ehcache緩存;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ehcache緩存.entity.User;

/**  
* <p>Description: </p>
* @ClassName: EhcacheController  
* @author wangtz  
* @date 2019年12月9日    
*/
@RestController
@RequestMapping("ehcache")
public class EhcacheController {

	@Autowired
	EhcacheService ehcacheService;
	
	@RequestMapping("find")
	public User find(String userId) {
		User user = ehcacheService.findByUserId(userId);
		return user;
	}
	
	@RequestMapping("save")
	public String save(String name, String userId) {
		User user = new User();
		user.setUserId(userId);
		user.setName(name);
		ehcacheService.saveAndflush(user);
		return "success";
	}
	
	 
	
	@RequestMapping("delete")
	public String delete(Long id, String userId) {
		ehcacheService.del(id, userId);
		return "success";
	}

	@RequestMapping("find_id")
	public User findId(Long id) {
		return ehcacheService.findId(id);
	}
}
