package com.example.demo.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * ClassName: Userinfo
 * Package: com.example.demo.entity
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 9:48
 * Version 1.0
 */
@Data
public class Userinfo {
    private Integer id; //可以接收 null 值
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private Integer state;
}
