package com.sframe.common.util;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.InputStreamReader;
import java.util.Locale;
import java.util.Properties;


/**
 * @Author c.9u@outlook.com
 * @Description  读取db.properties配置的属性
 * @Date 17:37 2019/2/26
 * @Param
 * @return
 **/
public class PropertiesUtil {
    private static Properties properties;
    private static final String dbFile = "db.properties";

    static {
        if(null == properties){
            loadProperties();
        }
    }

    public synchronized static void loadProperties(){
        if(null != properties){
            return;
        }
        try{
            Resource re = new ClassPathResource(dbFile);
            Properties p = new Properties();
            p.load(new InputStreamReader(re.getInputStream(), "utf-8"));
            properties = p;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        if(null == properties){
            loadProperties();
        }
        return properties.getProperty(key);
    }
}
