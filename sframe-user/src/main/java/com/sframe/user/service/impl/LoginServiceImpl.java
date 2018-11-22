package com.sframe.user.service.impl;

import com.sframe.common.model.SessionUserInfo;
import com.sframe.common.util.DesUtil;
import com.sframe.common.util.MD5;
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
    public SessionUserInfo login(String userAccount,String userPassword,String key) throws Exception {
        String password =  DesUtil.strDec(userPassword, key, null, null);
        BaseUser baseUser = (BaseUser) userDao.findUnique("from BaseUser where userAccount=? and isEnable='1'",userAccount);
        MD5 md5 = new MD5();
        String salt = baseUser.getSalt();
        String pass = md5.getMD5ofStr(password);
        if (md5.getMD5ofStr(pass+salt).equals(baseUser.getUserPassword())) {
            User user = new User();
            BeanUtils.copyProperties(user,baseUser);
            SessionUserInfo sessionUserInfo = new SessionUserInfo();
            sessionUserInfo.setUserId(user.getUserId());
            sessionUserInfo.setUserAccount(user.getUserAccount());
            sessionUserInfo.setRoleId(user.getRoleId());
            sessionUserInfo.setUserName(user.getUserName());
            sessionUserInfo.setEmail(user.getUserEmail());
            return sessionUserInfo;
        }
        return null;
    }
}
