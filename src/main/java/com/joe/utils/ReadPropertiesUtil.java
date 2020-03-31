package com.joe.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author joe
 * @date 2020-03-31 21:23
 */
public class ReadPropertiesUtil {
    public static String readProp(String key) {
        InputStream in = ReadPropertiesUtil.class.getClassLoader().getResourceAsStream("system.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}
