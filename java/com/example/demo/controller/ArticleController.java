package com.example.demo.controller;

import com.example.demo.common.AjaxResult;
import com.example.demo.common.AppVariable;
import com.example.demo.common.UserSessionUtils;
import com.example.demo.entity.ArticleInfo;
import com.example.demo.entity.Userinfo;
import com.example.demo.service.ArticleService;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

/**
 * ClassName: ArticleController
 * Package: com.example.demo.controller
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/9/2 12:16
 * Version 1.0
 */
@RestController //不返回静态页面的一个控制器
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/mylist")
    public AjaxResult getMyList(HttpServletRequest request) {
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo == null) {
            return AjaxResult.fail(-1,"非法请求");
        }
        List<ArticleInfo> list = articleService.getMyList(userinfo.getId());
        return AjaxResult.success(list);
    }

    @RequestMapping("/del")
    public AjaxResult del(HttpServletRequest request,Integer id) {
        if (id==null || id<=0) {
            //参数有误
            return AjaxResult.fail(-1,"参数异常");
        }
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo == null) {
            return AjaxResult.fail(-2,"用户未登录");
        }
        return AjaxResult.success(articleService.del(id, userinfo.getId()));
    }

    @RequestMapping("/detail")
    public AjaxResult getDetail(Integer id) {
        if (id == 0 || id <= 0) {
            return AjaxResult.fail(-1,"非法参数");
        }
        return AjaxResult.success(articleService.getDetail(id));
    }

    @RequestMapping("/incr-rcount")
    public AjaxResult incrRCount(Integer id){
        if (id != null && id > 0) {
            return AjaxResult.success(articleService.incrRCount(id));
        }
        return AjaxResult.fail(-1,"未知错误");
    }

    @RequestMapping("/add")
    public AjaxResult add(HttpServletRequest request, ArticleInfo articleInfo) {
        //1、非空校验
        if (articleInfo == null || !StringUtils.hasLength(articleInfo.getTitle()) ||
                !StringUtils.hasLength(articleInfo.getContent())) {
            return AjaxResult.fail(-1,"非法参数");
        }
        //2、数据库添加操作
        //先要得到当前登录用户的 uid
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo==null || userinfo.getId() <= 0) {
            //无效的登录用户
            return AjaxResult.fail(-2,"无效的登录用户");
        }
        articleInfo.setUid(userinfo.getId());
        //添加数据库并返回结果
        return AjaxResult.success(articleService.add(articleInfo));
    }

    @RequestMapping("/update")
    public AjaxResult update(HttpServletRequest request, ArticleInfo articleInfo) {
        //非空校验
        if (articleInfo==null || !StringUtils.hasLength(articleInfo.getTitle()) ||
                !StringUtils.hasLength(articleInfo.getContent()) ||
                articleInfo.getId()==null) {
            return AjaxResult.fail(-1,"非法参数");
        }
        //得到当前登录用户的id
        Userinfo userinfo = UserSessionUtils.getUser(request);
        if (userinfo==null || userinfo.getId()==null) {
            return AjaxResult.fail(-1,"无效用户");
        }
        //很核心的代码（解决了修改文章归属人判断的问题）
        articleInfo.setUid(userinfo.getId());
        articleInfo.setUpdatetime(LocalDateTime.now());
        return AjaxResult.success(articleService.update(articleInfo));
    }

    //根据分页，查询列表
    @RequestMapping("/listbypage")
    public AjaxResult getListByPage(Integer pindex,Integer psize) { //pindex 从1开始
        //1、参数校正
        if (pindex == null || pindex <= 1) {
            pindex = 1;
        }
        if (psize == null || psize <= 1) {
            psize = 2;
        }
        //分页公式 = （当前页面 -1）*每页最大显示条数
        int offset = (pindex - 1) * psize;
        //文章列表数据
        List<ArticleInfo> list = articleService.getListByPage(psize,offset);
        //当前列表总共有多少页
        //a.总共有多少条数据
        int totalCount = articleService.getCount();
        //b.总条数/psize（每页显示条数）
        double pcountdb = totalCount / (psize*1.0);
        //c.使用进一法得到总页面
        int pcount =(int) Math.ceil(pcountdb);//往上取整
        HashMap<String,Object> result = new HashMap<>();
        result.put("list",list);
        result.put("pcount",pcount);
        return  AjaxResult.success(result);
    }

}
