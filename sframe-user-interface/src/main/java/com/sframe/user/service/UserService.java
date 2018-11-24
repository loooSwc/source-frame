package com.sframe.user.service;

import com.sframe.common.dao.ParamsMap;
import com.sframe.common.dao.support.Page;

/**
 * 用户相关接口
 */
public interface UserService {
    /**
     * 获取用户分页列表
     * @return
     * @throws Exception
     */
    Page getUserPage(ParamsMap paramsMap) throws Exception;
}
