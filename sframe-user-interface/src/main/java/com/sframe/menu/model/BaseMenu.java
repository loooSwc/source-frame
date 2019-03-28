package com.sframe.menu.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: c.9u@outlook.com
 * \* Date: 2018/11/22
 * \* Time: 17:11
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Entity
@Table(name = "sys_menu")
public class BaseMenu implements java.io.Serializable{
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "menu_id", unique = true, nullable = false, length = 32)
	private String menuId;          //主键id

	@Column(name = "menu_name")
	private String menuName;        //菜单名称

	@Column(name = "parent_id")
	private String parentId;        //父菜单id

	@Column(name = "menu_router")
	private String menuRouter;      //菜单路由地址

	@Column(name = "menu_desc")
	private String menuDesc;        //菜单简介

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;        //创建时间

	@Column(name = "create_user")
	private String createUser;      //创建人

	@Column(name = "menu_icon")
	private String menuIcon;        //菜单icon

	@Column(name = "menu_sort")
	private Integer menuSort;       //菜单排序值

	@Column(name = "is_enable")
	private String isEnable;        //是否启用 1为启用，0为禁用

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getMenuRouter() {
		return menuRouter;
	}

	public void setMenuRouter(String menuRouter) {
		this.menuRouter = menuRouter;
	}

	public String getMenuDesc() {
		return menuDesc;
	}

	public void setMenuDesc(String menuDesc) {
		this.menuDesc = menuDesc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getMenuIcon() {
		return menuIcon;
	}

	public void setMenuIcon(String menuIcon) {
		this.menuIcon = menuIcon;
	}

	public Integer getMenuSort() {
		return menuSort;
	}

	public void setMenuSort(Integer menuSort) {
		this.menuSort = menuSort;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}
}