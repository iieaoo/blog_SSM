package com.example.demo.mapper;

import com.example.demo.entity.Userinfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * ClassName: UserMapper
 * Package: com.example.demo.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 9:34
 * Version 1.0
 */
@Mapper
public interface UserMapper {

    //注册
    int reg(Userinfo userinfo);

    //根据用户名查询对象 userinfo 对象
    Userinfo getUserByName(@Param("username") String username);

    Userinfo getUserById(@Param("id") Integer id);

}
