package com.example.demo.service;

import com.example.demo.entity.Userinfo;
import com.example.demo.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ClassName: UserService
 * Package: com.example.demo.service
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 9:56
 * Version 1.0
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    public int reg(Userinfo userinfo) {
        return userMapper.reg(userinfo);
    }

    public Userinfo getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    public  Userinfo getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

}
