package com.sframe.login.controller;

import com.alibaba.fastjson.JSONObject;
import com.sframe.common.ConstantClazz;
import com.sframe.common.model.ResponseJSON;
import com.sframe.common.model.SessionUserInfo;
import com.sframe.common.util.StringUtil;
import com.sframe.login.service.LoginService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
@RequestMapping("/user/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String findAuthorityList(HttpServletRequest request, HttpServletResponse response, @RequestBody Map map) throws Exception {
        ResponseJSON responseJSON = new ResponseJSON();
        String userAccount = MapUtils.getString(map,"userAccount");
        String userPassword = MapUtils.getString(map,"userPassword");
        String key = (String) request.getSession().getAttribute(ConstantClazz.SYS_SESSION_PASSWORD);
        SessionUserInfo sessionUserInfo = loginService.login(userAccount,userPassword,key);
        if(sessionUserInfo!= null){
            request.getSession().setAttribute(ConstantClazz.USER_SESSION_INFO, sessionUserInfo);
            Cookie userCookie = new Cookie("account", "%22" + sessionUserInfo.getUserAccount() + "%22");
            userCookie.setPath("/");
            userCookie.setMaxAge(24 * 60 * 60 * 15);
            response.addCookie(userCookie);
        }
        return JSONObject.toJSONString(responseJSON);
    }

    /**
     * @Author cxy@acmtc.com
     * @Description  生成密码加密传输时的key
     * @Date 17:14 2018/11/17
     * @Param
     * @return
     **/
    @RequestMapping(value = "/getPassKey", method = RequestMethod.POST)
    @ResponseBody
    public String getPassKey(HttpServletRequest request,@RequestBody Map map){
        String keyType =  MapUtils.getString(map,"keyType");
        ResponseJSON json = new ResponseJSON ();
        try {
            int key = (int)((Math.random()*9+1)*100000);
            String passKey = String.valueOf(key);
            request.getSession().setAttribute(StringUtil.isEmpty(keyType)?ConstantClazz.SYS_SESSION_PASSWORD:keyType, passKey);
            json.setData(passKey);
        } catch (Exception e) {
            throw e;
        }
        return JSONObject.toJSONString(json);
    }
}
