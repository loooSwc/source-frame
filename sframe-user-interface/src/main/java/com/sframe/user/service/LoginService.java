package com.sframe.user.service;

import com.sframe.user.model.User;

public interface LoginService {
    User login(String userAccount,String userPassword,String key) throws Exception;
}
