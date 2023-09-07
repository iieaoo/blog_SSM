package com.example.demo.service;

import com.example.demo.entity.ArticleInfo;
import com.example.demo.mapper.ArticleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClassName: ArticleService
 * Package: com.example.demo.service
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 19:18
 * Version 1.0
 */
@Service
public class ArticleService {


    @Resource
    private ArticleMapper articleMapper;

    public int getArtCountByUid(Integer uid) {
        return articleMapper.getArtCountByUid(uid);
    }

    public List<ArticleInfo> getMyList(Integer uid) {
        return articleMapper.getMyList(uid);
    }

    public int del(Integer id, Integer uid) {
        return articleMapper.del(id, uid);
    }

    public ArticleInfo getDetail(Integer id) {
        return articleMapper.getDetail(id);
    }

    public int incrRCount(Integer id) {
        return articleMapper.incrRCount(id);
    }

    public int add(ArticleInfo articleInfo) {
        return articleMapper.add(articleInfo);
    }

    public int update(ArticleInfo articleInfo){
        return articleMapper.update(articleInfo);
    }

    public List<ArticleInfo> getListByPage(Integer psize,Integer offsize) {
        return articleMapper.getListByPage(psize,offsize);
    }

    public int getCount() {
        return articleMapper.getCount();
    }

}
