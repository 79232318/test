package com.spring.springboot_shiro.service.impl;

import org.springframework.stereotype.Service;

import com.spring.springboot_shiro.dao.UserInfoDao;
import com.spring.springboot_shiro.model.UserInfo;
import com.spring.springboot_shiro.service.UserInfoService;

import javax.annotation.Resource;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    @Resource
    private UserInfoDao userInfoDao;
    @Override
    public UserInfo findByUsername(String username) {
        System.out.println("UserInfoServiceImpl.findByUsername()");
        return userInfoDao.findByUsername(username);
    }
}