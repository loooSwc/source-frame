package com.sframe.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.sframe.user.model.User;
import com.sframe.user.service.LoginService;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/user/login")
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public String findAuthorityList(@RequestParam Map map) throws Exception {
        String userAccount = MapUtils.getString(map,"userAccount");
        String userPassword = MapUtils.getString(map,"userPassword");
        User user = loginService.login(userAccount,userPassword);

        return JSONObject.toJSONString(user);
    }
}
