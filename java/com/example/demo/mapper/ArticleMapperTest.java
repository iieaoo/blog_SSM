package com.example.demo.mapper;

import com.example.demo.entity.ArticleInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: ArticleMapperTest
 * Package: com.example.demo.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 19:16
 * Version 1.0
 */
@SpringBootTest
class ArticleMapperTest {

    @Resource
    private ArticleMapper articleMapper;

    @Test
    void getArtCountByUid() {
        int result = articleMapper.getArtCountByUid(1);
        System.out.println("文章总数：" + result);
    }

    @Test
    void getListByPage() {
        List<ArticleInfo> list = articleMapper.getListByPage(3,0);
        System.out.println(list);
        System.out.println("--------------------------");
        List<ArticleInfo> list2 = articleMapper.getListByPage(2,3);
        System.out.println(list2);
    }
}