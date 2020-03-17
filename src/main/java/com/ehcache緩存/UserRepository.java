package com.ehcache緩存;



import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.ehcache緩存.entity.User;





public interface UserRepository extends JpaRepository<User, Long>,JpaSpecificationExecutor<User> {
	static final String DEMO_CACHE_NAME = "users";
	 
	@Cacheable(value=DEMO_CACHE_NAME,key="#userId")
	User findByUserId(String userId);
	 
 

 

	 

	
    
     
	 
}
