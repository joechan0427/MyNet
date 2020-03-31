package com.joe.service;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author joe
 * @date 2020-03-31 15:43
 */
@Service
public class EmailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private SimpleMailMessage simpleMailMessage;
    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    /**
     *
     * @Description: 从模板中构建邮件内容
     * @param nickName        用户昵称
     * @param content        邮件内容
     * @param email            接受邮件
     *
     * @author leechenxiang
     * @date 2017年2月5日 下午1:22:00
     */
    public void send(String nickName, String content, String email) {
        String to = email;
        String text = "";
        Map<String, String> map = new HashMap<String, String>(1);
        map.put("nickName", nickName);
        map.put("content", content);
        try {
            // 根据模板内容，动态把map中的数据填充进去，生成HTML
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate("mail.ftl");
            // map中的key，对应模板中的${key}表达式
            text = FreeMarkerTemplateUtils.processTemplateIntoString(template, map);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        sendMail(to, null, text);
    }

    /**
     *
     * @Description: 执行发送邮件
     * @param to            收件人邮箱
     * @param subject        邮件主题
     * @param content        邮件内容
     *
     * @author leechenxiang
     * @date 2017年2月5日 下午1:22:34
     */
    public void sendMail(String to, String subject, String content) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(message, true, "UTF-8");
            messageHelper.setFrom(simpleMailMessage.getFrom());
            if (subject != null) {
                messageHelper.setSubject(subject);
            } else {
                messageHelper.setSubject(simpleMailMessage.getSubject());
            }
            messageHelper.setTo(to);
            messageHelper.setText(content, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
