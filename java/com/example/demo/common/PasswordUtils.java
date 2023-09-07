package com.example.demo.common;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * ClassName: PasswordUtil
 * Package: com.example.demo.common
 * Description:
 *
 * @Author 全家乐
 * @Create 2023/9/4 20:28
 * Version 1.0
 */
public class PasswordUtils {
    //1、加盐并生成密码
    //@para password:明文密码
    //@return 保存到数据库中的密码
    public static String encrypt(String password) {
        //a.盐值(32位)
        String salt = UUID.randomUUID().toString().replace("-","");
        //b.生成加盐之后的密码
        String saltPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        //c.生成最终密码（保存到数据库中的密码）【约定格式：32位盐值+$+32位加盐之后】
        String finalPassword = salt + "$" + saltPassword;
        return finalPassword;
    }

    //2、生成加盐的密码（方法一的重载）
    //@param password 明文
    //@param salt 固定的盐值
    //@return 最终密码
    public static String encrypt(String password, String salt) {
        //1、生成一个加盐之后的密码
        String saltPassword = DigestUtils.md5DigestAsHex((salt + password).getBytes());
        //2、生成最终的密码【约定格式：32位盐值+$+32位加盐之后】
        String finalPassword = salt+"$"+saltPassword;
        return finalPassword;
    }

    //3、验证密码
    //@param inputPassword 用户输入的明文密码
    //@param finalPassword 数据库保存的最终密码
    public static boolean check(String inputPassword,String finalPassword) {
        if (StringUtils.hasLength(inputPassword) && StringUtils.hasLength(finalPassword) &&
                finalPassword.length()==65) {
            //1、得到盐值
            String salt = finalPassword.split("\\$")[0];  //分割后取第一部分
            //2、使用之前加密的步骤，将明文密码和已经得到的盐值进行加密，生成最终的密码
            String confirmPassword =PasswordUtils.encrypt(inputPassword,salt);
            //3、对比两个密码是否相同
            return confirmPassword.equals(finalPassword);
        }
        return false;
    }

    public static void main(String[] args) {
        String password = "123456";

        String finalPassword = PasswordUtils.encrypt(password);
        System.out.println("第一加密：" + finalPassword);
        //比对
        String inputPassword1 = "12345";
        System.out.println("对比 " + inputPassword1 + "是否等于" + password + "->" + PasswordUtils.check(inputPassword1,finalPassword));
        String inputPassword2 = "123456";
        System.out.println("对比 " + inputPassword2 + "是否等于" + password + "->" + PasswordUtils.check(inputPassword2,finalPassword));
    }
}
