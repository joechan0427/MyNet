package com.joe.controller;

import com.joe.dao.UserMapper;
import com.joe.entity.User;
import com.joe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;


/**
 * @author joe
 * @date 2020-03-27 14:33
 */
@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;


    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public String doRegister(@Valid User user, BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (!allErrors.isEmpty()) {
            return "error";
        }

        return userService.SignUp(user);
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(String userEmail) {
        return userMapper.selectByEmail(userEmail) == null ? "noEmail" : "hasEmail";
    }

    @RequestMapping("/active")
    public String active(String userEmail, String activeCode, Model model) {
//        System.out.println(userEmail+activeCode);
        Map<String, String> map = userService.activeAccount(userEmail, activeCode);
        model.addAttribute("state", map.get("state"));
        model.addAttribute("message", map.get("message"));
        return "activeResult";
    }
}
