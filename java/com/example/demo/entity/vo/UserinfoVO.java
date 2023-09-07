package com.example.demo.entity.vo;

import com.example.demo.entity.Userinfo;
import lombok.Data;

/**
 * ClassName: UserinfoVO
 * Package: com.example.demo.entity.vo
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 19:21
 * Version 1.0
 */
@Data
public class UserinfoVO extends Userinfo {
    private Integer artCount;   //此人发表的文章总数
}
