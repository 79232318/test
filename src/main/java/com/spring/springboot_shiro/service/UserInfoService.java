package com.spring.springboot_shiro.service;

import com.spring.springboot_shiro.model.UserInfo;

public interface UserInfoService {
    /**通过username查找用户信息;*/
    public UserInfo findByUsername(String username);
}