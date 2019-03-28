package com.sframe.role.service.impl;

import com.sframe.common.util.BeanUtils;
import com.sframe.role.dao.RoleDao;
import com.sframe.role.model.BaseRole;
import com.sframe.role.model.Role;
import com.sframe.role.service.RoleService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: c.9u@outlook.com
 * \* Date: 2018/12/6
 * \* Time: 14:32
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleDao roleDao;
	@Override
	public List<Role> getRoleList() throws Exception {
		List<BaseRole> list = roleDao.find("from BaseRole order by createTime asc");
		List<Role> roleList = new ArrayList<>();
		if(CollectionUtils.isNotEmpty(list)){
			list.stream().forEach(baseRole -> {
				Role role = new Role();
				BeanUtils.copyPropertiesByModel(role,baseRole);
				roleList.add(role);
			});
		}
		return roleList;
	}
}