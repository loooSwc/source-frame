package com.sframe.menu.service;/**
 * @Auther: cxy@acmtc.com
 * @Date: 2018/11/22 17:19
 * @Description:
 */

import com.sframe.menu.model.Menu;

import java.util.List;

/**
 \* Created with IntelliJ IDEA.
 \* User: cxy@acmtc.com
 \* Date: 2018/11/22
 \* Time: 17:19
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
public interface MenuService {
	
	/**
	 * @Author cxy@acmtc.com
	 * @Description  根据角色获取菜单
	 * @Date 17:19 2018/11/22
	 * @Param 
	 * @return 
	 **/
	List<Menu> getMenuList() throws Exception;
}
