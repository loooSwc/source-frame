package com.sframe.login.service;

import com.sframe.common.model.SessionUserInfo;

public interface LoginService {
    SessionUserInfo login(String userAccount, String userPassword, String key) throws Exception;
}
