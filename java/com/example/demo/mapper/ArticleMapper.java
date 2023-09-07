package com.example.demo.mapper;

import com.example.demo.entity.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClassName: ArticleMapper
 * Package: com.example.demo.mapper
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 19:13
 * Version 1.0
 */
@Mapper
public interface ArticleMapper {

    int getArtCountByUid(@Param("uid") Integer uid);

    List<ArticleInfo> getMyList(@Param("uid") Integer uid);

    int del(@Param("id") Integer id, @Param("uid") Integer uid);

    ArticleInfo getDetail(@Param("id") Integer id);

    int incrRCount(@Param("id") Integer id);

    int add(ArticleInfo articleInfo);

    int update(ArticleInfo articleInfo);

    List<ArticleInfo> getListByPage(@Param("psize") Integer psize,
                                    @Param("offsize") Integer offsize);//跳过

    int getCount();

}
