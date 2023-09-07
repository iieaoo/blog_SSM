package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * ClassName: AppConfig
 * Package: com.example.demo.config
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/8/31 17:33
 * Version 1.0
 */
@Configuration
public class AppConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/editor.md/**")
                .excludePathPatterns("/image/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/reg.html")
                .excludePathPatterns("/blog_list.html")
                .excludePathPatterns("/blog_content.html")
                .excludePathPatterns("/art/detail")
                .excludePathPatterns("/art/incr-rcount")
                .excludePathPatterns("/user/getuserbyid")
                .excludePathPatterns("/art/listbypage")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/reg");
    }
}
