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

	/**
	 * @Author cxy@acmtc.com
	 * @Description  添加用户
	 * @Date 14:53 2018/12/6
	 * @Param
	 * @return
	 **/
	void addUser(User user) throws Exception;

	/**
	 * @Author cxy@acmtc.com
	 * @Description  校验用户账户是否被占用
	 * @Date 16:02 2018/12/6
	 * @Param
	 * @return true 被占用 false 未被占用
	 **/
	boolean checkUserAccount(String userAccount) throws Exception;

	/**
	 * @Author cxy@acmtc.com
	 * @Description  编辑用户
	 * @Date 18:13 2018/12/6
	 * @Param
	 * @return
	 **/
	void editUser(User user) throws Exception;

	/**
	 * @Author cxy@acmtc.com
	 * @Description  更改状态
	 * @Date 18:27 2018/12/6
	 * @Param
	 * @return
	 **/
	void changeStatus(User user) throws Exception;
}
