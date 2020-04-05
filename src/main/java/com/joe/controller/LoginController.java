package com.joe.controller;

import com.joe.dao.UserMapper;
import com.joe.entity.User;
import com.joe.service.EmailService;
import com.joe.service.UserService;
import com.joe.utils.vcode.Captcha;
import com.joe.utils.vcode.GifCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author joe
 * @date 2020-03-26 16:09
 */
@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    UserMapper userMapper;

    @Autowired
    EmailService emailService;

    @RequestMapping("/login")
    public String login(User user, HttpServletRequest request) {
        System.out.println("tologin");
        System.out.println("login"+request.getSession().getAttribute("vcodeWord").toString());
        return "register";
    }

    /**
     * 获取验证码（Gif版本）
     * @param response
     */
    @RequestMapping(value="/getGifCode",method= RequestMethod.GET)
    public void getGifCode(HttpServletResponse response, HttpServletRequest request){
        try {
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expires", 0);
            response.setContentType("image/gif");
            /*
             * gif格式动画验证码
             * 宽，高，位数。
             */
            Captcha captcha = new GifCaptcha(146,42,4);
            //输出
            ServletOutputStream out = response.getOutputStream();
            captcha.out(out);
            out.flush();
            //存入Shiro会话session
            System.out.println( captcha.text().toLowerCase());
            request.getSession().setAttribute("captcha", captcha.text().toLowerCase());
//            TokenManager.setVal2Session(VerifyCodeUtils.V_CODE, captcha.text().toLowerCase());
        } catch (Exception e) {
//            LoggerUtils.fmtError(getClass(),e, "获取验证码异常：%s",e.getMessage());
            e.printStackTrace();
        }
    }

    @RequestMapping("/toForgetPassword")
    public String toForgetPassword() {
        return "forgetPassword";
    }

    @RequestMapping("/forgetPassword")
    @ResponseBody
    public String forgetPassword(User newUser) {
//        User user = userMapper.selectByEmail(newUser.getUserEmail());
        return userService.forgetPassword(newUser);
    }


}
