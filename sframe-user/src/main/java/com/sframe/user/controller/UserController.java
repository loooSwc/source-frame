package com.sframe.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.sframe.common.dao.ParamsMap;
import com.sframe.common.dao.support.Page;
import com.sframe.user.dao.UserDao;
import com.sframe.user.model.BaseUser;
import com.sframe.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Hello world!
 *
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/getUserPage")
    @ResponseBody
    public Object getUserPage(Page page, @RequestBody ParamsMap paramsMap) throws Exception {
        try{
            page = userService.getUserPage(paramsMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSONObject.toJSONString(page);
    }
}
