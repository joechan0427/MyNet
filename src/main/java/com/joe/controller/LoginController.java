package com.joe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author joe
 * @date 2020-03-26 16:09
 */
@Controller
public class LoginController {

    @RequestMapping("/login")
    public String login() {
        return "register";
    }
}
