package com.sframe.user.service.impl;

import com.sframe.user.dao.UserDao;
import com.sframe.user.model.BaseUser;
import com.sframe.user.model.User;
import com.sframe.user.service.LoginService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserDao userDao;
    @Override
    public User login(String userAccount,String userPassword) throws Exception {
        StringBuffer sb = new StringBuffer();
        List<BaseUser> list = userDao.find("from BaseUser where userAccount=? and userPassword=?",userAccount,userPassword);
        User user = new User();
        if(CollectionUtils.isNotEmpty(list)){
            BaseUser baseUser = list.get(0);
            BeanUtils.copyProperties(user,baseUser);
        }
        return user;
    }
}
