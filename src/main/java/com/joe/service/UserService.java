package com.joe.service;

import com.joe.dao.UserMapper;
import com.joe.entity.User;
import com.joe.utils.ReadPropertiesUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Console;
import java.util.UUID;

/**
 * @author joe
 * @date 2020-03-31 16:52
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailService emailService;

    public String SignUp(User user) {
//        查询是否存在用户
        if (userMapper.selectByEmail(user.getUserEmail()) != null) {
            return "用户已存在";
        }

        String salt = UUID.randomUUID().toString().substring(0,4);
        user.setSalt(salt);
        Md5Hash password = new Md5Hash(user.getUserPassword(), salt, 2);
        user.setUserPassword(password.toString());
        Md5Hash activeCode = new Md5Hash(user.getUserEmail(), salt, 2);
        user.setActiCode(activeCode.toString());
        String url = ReadPropertiesUtil.readProp("projectPath") + "active?userEmail="+user.getUserEmail() + "&activeCode="+activeCode;
        try {
            emailService.send("welcome!", user.getUserNickname(), url, user.getUserEmail());
        }catch (Exception e) {
            System.out.println(e);
            return "error";
        }
        userMapper.insertSelective(user);
        return "success";
    }

    public void activeAccount(String userEmail, String activeCode) {
//        TODO: 激活账户操作
    }
}
