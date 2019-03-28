package com.sframe.menu.service;/**
 * @Auther: c.9u@outlook.com
 * @Date: 2018/11/22 17:19
 * @Description:
 */

import com.sframe.menu.model.Menu;

import java.util.List;

/**
 \* Created with IntelliJ IDEA.
 \* User: c.9u@outlook.com
 \* Date: 2018/11/22
 \* Time: 17:19
 \* To change this template use File | Settings | File Templates.
 \* Description: 
 \*/
public interface MenuService {
	
	/**
	 * @Author c.9u@outlook.com
	 * @Description  根据角色获取菜单
	 * @Date 17:19 2018/11/22
	 * @Param 
	 * @return 
	 **/
	List<Menu> getMenuList() throws Exception;
}
