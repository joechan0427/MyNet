package com.joe.utils;

import org.elasticsearch.common.xcontent.XContentBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;


/**
 * 1.往浏览器输出中文数据
 * 2.校验码是否正确
 * 3.设置属性到session中
 * Created by ozc on 2017/12/8.
 *
 * @author ozc
 * @version 1.0
 */
public class WebUtils {


    /**
     * 向浏览器输出JSON数据
     * @param result
     * @param response
     */
    public static void printCNJSON(String result, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.setContentType("application/json;charset=utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(result);
            writer.flush();
            writer.close();
        } catch (IOException var3) {
            var3.printStackTrace();
        }

    }

    /**
     * 校验验证码是否正确
     * true：正确
     * false：错误
     *
     * @param request
     * @return
     */
    public static boolean validateCaptcha(HttpServletRequest request) {

        //在这里进行验证码的校验
        String validateCode = (String) request.getSession().getAttribute("captcha");
        String randomcode = request.getParameter("captcha");

        if (randomcode != null && validateCode != null && randomcode.equalsIgnoreCase(validateCode)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 设置数据到session域对象中
     * @param request
     * @param key
     * @param value
     */
    public static void setValue2Session(HttpServletRequest request, String key, Object value) {
        HttpSession session = request.getSession();
        session.setAttribute(key, value);
    }

    /**
     * string转成JSON，针对Elasticsearch的
     * @param strings
     * @return
     * @throws IOException
     */
    public static String String2JSON(String... strings) throws IOException {

        String suggestName = strings[2];
        if (suggestName.length() > 0) {

        }
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("userId", strings[0])
                .field("webSiteAddr", strings[1])
                .field("webSiteName", strings[2])
                //自动补全字段
                .field("suggestName", strings[2])
                .endObject();

        return builder.string();
    }

}
