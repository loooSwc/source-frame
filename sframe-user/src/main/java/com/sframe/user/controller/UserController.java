package com.sframe.user.controller;

import com.sframe.user.dao.UserDao;
import com.sframe.user.model.BaseUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hello world!
 *
 */
@Controller
@Transactional
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserDao userDao;
    @RequestMapping("/find")
    @ResponseBody
    public Object findAuthorityList() throws Exception {
        BaseUser baseUser = userDao.findOne("1");
        return baseUser;
    }
}
