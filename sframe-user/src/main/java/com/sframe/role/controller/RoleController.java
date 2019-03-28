package com.sframe.role.controller;

import com.alibaba.fastjson.JSONObject;
import com.sframe.common.model.ResponseJSON;
import com.sframe.role.model.Role;
import com.sframe.role.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: c.9u@outlook.com
 * \* Date: 2018/12/6
 * \* Time: 14:21
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/sys/role")
public class RoleController {
	private static final Logger log = LoggerFactory.getLogger(RoleController.class);

	@Autowired
	private RoleService roleService;


	@RequestMapping(value = "/getRoleList",method = RequestMethod.POST)
	@ResponseBody
	public String getRoleList() throws Exception {
		ResponseJSON responseJSON = new ResponseJSON();
		try{
			List<Role> roleList = roleService.getRoleList();
			responseJSON.setData(roleList);
		}catch (Exception e){
			responseJSON.setMessage(e.getMessage());
			log.error(e.getMessage(),e);
			throw e;
		}
		return JSONObject.toJSONString(responseJSON);
	}
}