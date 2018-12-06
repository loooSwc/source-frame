package com.sframe.role.service;/**
 * @Auther: cxy@acmtc.com
 * @Date: 2018/12/6 14:32
 * @Description:
 */

import com.sframe.role.model.Role;

import java.util.List;

/**
 \* Created with IntelliJ IDEA.
 \* User: cxy@acmtc.com
 \* Date: 2018/12/6
 \* Time: 14:32
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
public interface RoleService {

	/**
	 * @Author cxy@acmtc.com
	 * @Description  获取角色列表
	 * @Date 14:33 2018/12/6
	 * @Param
	 * @return
	 **/
	List<Role> getRoleList() throws Exception;
}
