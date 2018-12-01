package com.sframe.user.service;

import com.sframe.common.dao.ParamsMap;
import com.sframe.common.dao.support.Page;
import com.sframe.user.model.User;

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

	/**
	 * @Author cxy@acmtc.com
	 * @Description  获取用户详情信息
	 * @Date 17:26 2018/12/1
	 * @Param
	 * @return
	 **/
	User getUserDetail(String userId) throws Exception;
}
