package com.joe.service;

import com.joe.dao.UserMapper;
import com.joe.entity.User;
import com.joe.utils.ReadPropertiesUtil;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.io.Console;
import java.util.HashMap;
import java.util.Map;
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
        // 查询是否存在用户
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

    public Map<String, String> activeAccount(String userEmail, String activeCode) {
        User user = userMapper.selectByEmail(userEmail);
        String state = "error";
        String message;
        HashMap<String, String> model = new HashMap<>(2);
        if (user == null || user.getActiState() == User.ACTIVED) {
            message = "未注册或已激活账户!";
        }
        else if (activeCode == null || !activeCode.equals(user.getActiCode())) {
            message = "参数错误，激活失败!";
        } else if (System.currentTimeMillis() - user.getTokenExptime().getTime() > 1000*60*60){
            message = "已超过60分钟，请重新注册";
            userMapper.deleteByPrimaryKey(user.getUserId());
        } else {
            state = "success";
            message = "激活成功！";
            user.setActiState(User.ACTIVED);
            userMapper.updateByPrimaryKey(user);
        }
        model.put("state", state);
        model.put("message", message);
        return model;
    }

    public User validateUserExist(String userEmail) {
        User user = userMapper.selectByEmail(userEmail);
        if (user == null || user.getActiState() == User.NOT_ACTIVED)
            return null;
        return user;
    }
}
