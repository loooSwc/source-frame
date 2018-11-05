package com.sframe.common.controller;

import com.sframe.common.ConstantClazz;
import com.sframe.common.util.StringUtil;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.ServletContextEvent;


public class InitController extends ContextLoaderListener{
    
    public void contextInitialized(ServletContextEvent event) {
        if(StringUtil.isEmpty(ConstantClazz.WEB_PATH)){
            ConstantClazz.WEB_PATH =event.getServletContext().getRealPath("");
        }
        super.contextInitialized(event);
    }
}
