package com.sframe.menu.model;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: cxy@acmtc.com
 * \* Date: 2018/11/22
 * \* Time: 17:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
public class Menu extends BaseMenu {

	List<Menu> childMenus;      //子菜单

	public List<Menu> getChildMenus() {
		return childMenus;
	}

	public void setChildMenus(List<Menu> childMenus) {
		this.childMenus = childMenus;
	}
}