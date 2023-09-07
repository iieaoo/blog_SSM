package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class DemoApplicationTests {

    public static void main(String[] args) {
        int totalCount = 5;
        int psize = 2;
        double pcount = totalCount / (psize * 1.0) ;
        System.out.println(Math.ceil(pcount));  //往上取整
    }

    @Test
    void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String password = "123456";
        String finalPassword = passwordEncoder.encode(password);
        System.out.println("第1次加密：" + finalPassword);
        System.out.println("第2次加密：" + passwordEncoder.encode(password));
        System.out.println("第3次加密：" + passwordEncoder.encode(password));
    }

}
