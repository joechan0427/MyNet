package com.joe.controller;

import com.joe.dao.UserMapper;
import com.joe.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;


/**
 * @author joe
 * @date 2020-03-27 14:33
 */
@Controller
public class RegisterController {
    @Autowired
    UserMapper userMapper;

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/doRegister")
    @ResponseBody
    public String doRegister(@Valid User user, BindingResult bindingResult) {
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        if (allErrors != null && !allErrors.isEmpty()) {
            return "error";
        }
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPassword());
        System.out.println("doregister");
        return "success";
    }

    @RequestMapping("/validateEmail")
    @ResponseBody
    public String validateEmail(String userEmail) {
//        System.out.println("validateEmail"+userEmail);

//        writer.write("Email");
        return userMapper.selectByEmail(userEmail) == null ? "noEmail" : "hasEmail";
    }

    @RequestMapping("/active")
    public String active(String userEmail, String activeCode) {
//        System.out.println(userEmail+activeCode);

        return "redirect:/index.jsp";
    }
}
