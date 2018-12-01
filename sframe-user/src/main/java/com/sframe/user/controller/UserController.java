package com.sframe.user.controller;

import com.alibaba.fastjson.JSONObject;
import com.sframe.common.dao.ParamsMap;
import com.sframe.common.dao.support.Page;
import com.sframe.common.model.ResponseJSON;
import com.sframe.user.dao.UserDao;
import com.sframe.user.model.BaseUser;
import com.sframe.user.model.User;
import com.sframe.user.service.UserService;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Hello world!
 *
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {
    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getUserPage",method = RequestMethod.POST)
    @ResponseBody
    public Object getUserPage(Page page, @RequestBody ParamsMap paramsMap) throws Exception {
        try{
            page = userService.getUserPage(paramsMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return JSONObject.toJSONString(page);
    }

    @RequestMapping(value = "/getUserDetail",method = RequestMethod.POST)
    @ResponseBody
    public Object getUserDetail(@RequestBody Map map) throws Exception {
        ResponseJSON responseJSON = new ResponseJSON();
        try{
            String userId = MapUtils.getString(map,"userId");
            User user = userService.getUserDetail(userId);
            responseJSON.setData(user);
        }catch (Exception e){
            responseJSON.setMessage(e.getMessage());
            log.error(e.getMessage(),e);
            throw e;
        }
        return JSONObject.toJSONString(responseJSON);
    }
}
