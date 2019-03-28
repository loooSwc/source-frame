package com.sframe.menu.service.impl;

import com.sframe.common.ConstantClazz;
import com.sframe.common.model.SessionUserInfo;
import com.sframe.common.util.SessionUtil;
import com.sframe.common.util.StringUtil;
import com.sframe.menu.dao.MenuDao;
import com.sframe.menu.model.Menu;
import com.sframe.menu.service.MenuService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: c.9u@outlook.com
 * \* Date: 2018/11/22
 * \* Time: 17:20
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuDao menuDao;
	@Override
	public List<Menu> getMenuList() throws Exception {
		SessionUserInfo sessionUserInfo = (SessionUserInfo) SessionUtil.getSession().getAttribute(ConstantClazz.USER_SESSION_INFO);
		String roleId = sessionUserInfo.getRoleId();
		StringBuffer sb = new StringBuffer();
		sb.append("  SELECT  ");
		sb.append("          menu.menu_id,  ");
		sb.append("          menu.menu_name,  ");
		sb.append("          menu.parent_id,  ");
		sb.append("          menu.menu_router,   ");
		sb.append("          menu.menu_icon   ");
		sb.append("  FROM  ");
		sb.append("          sys_menu menu  ");
		sb.append("          LEFT JOIN role_menu rm ON rm.menu_id = menu.menu_id  ");
		sb.append("          LEFT JOIN sys_role sr ON sr.role_id = rm.role_id   ");
		sb.append("  WHERE  ");
		sb.append("          rm.role_id = ?   ");
		sb.append("          AND menu.is_enable = '1'   ");
		sb.append("  ORDER BY  ");
		sb.append("          menu.menu_sort ASC  ");
		Query query = menuDao.createSQLNativeQuery(sb.toString(),roleId);
		List list = query.getResultList();
		List<Menu> menuList = new ArrayList<>();
		Map<String,List<Menu>> menuMap = new HashMap<>();
		if(CollectionUtils.isNotEmpty(list)){
			for(int i = 0; i<list.size();i++){
				Object[] objs = (Object[])list.get(i);
				int index = 0;
				Menu menu = new Menu();
				menu.setMenuId(StringUtil.objToString(objs[index++]));
				menu.setMenuName(StringUtil.objToString(objs[index++]));
				menu.setParentId(StringUtil.objToString(objs[index++]));
				menu.setMenuRouter(StringUtil.objToString(objs[index++]));
				menu.setMenuIcon(StringUtil.objToString(objs[index++]));
				if(StringUtil.isEmpty(menu.getParentId())){
					menuList.add(menu);
					continue;
				}
				List<Menu> childMenus = menuMap.get(menu.getParentId());
				if(CollectionUtils.isEmpty(childMenus)){
					childMenus = new ArrayList<>();
				}
				childMenus.add(menu);
				menuMap.put(menu.getParentId(),childMenus);
			}
		}
		menuList.stream().forEach(menu -> {
			menu.setChildMenus(menuMap.get(menu.getMenuId()));
		});
		return menuList;
	}
}