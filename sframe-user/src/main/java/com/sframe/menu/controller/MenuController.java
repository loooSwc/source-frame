package com.sframe.menu.controller;

import com.alibaba.fastjson.JSONObject;
import com.sframe.common.ConstantClazz;
import com.sframe.common.model.ResponseJSON;
import com.sframe.common.model.SessionUserInfo;
import com.sframe.common.util.SessionUtil;
import com.sframe.menu.model.Menu;
import com.sframe.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: c.9u@outlook.com
 * \* Date: 2018/11/22
 * \* Time: 17:14
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Controller
@RequestMapping("/sys/menu")
public class MenuController {
	@Autowired
	private MenuService menuService;

	@RequestMapping(value = "/getMenuList",method = RequestMethod.POST)
	@ResponseBody
	public String getMenuList() throws Exception {
		ResponseJSON responseJSON = new ResponseJSON();
		try{
			List<Menu> list = menuService.getMenuList();
			responseJSON.setData(list);
		}catch (Exception e){
			throw e;
		}
		return JSONObject.toJSONString(responseJSON);
	}
}