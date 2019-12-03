package com.spring.springboot_shiro.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.springboot_shiro.model.UserInfo;

public interface UserInfoDao extends CrudRepository<UserInfo,Long> {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}