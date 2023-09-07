package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * ClassName: ArticleInfo
 * Package: com.example.demo.entity
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/9/2 12:00
 * Version 1.0
 */
@Data
public class ArticleInfo {
    private Integer id;
    private String title;
    private String content;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private LocalDateTime createtime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updatetime;
    private Integer uid;
    private Integer rcount;
    private Integer state;
}
