package com.sframe.user.service.impl;

import com.sframe.common.dao.ParamsMap;
import com.sframe.common.dao.QueryMap;
import com.sframe.common.dao.support.Page;
import com.sframe.common.util.StringUtil;
import com.sframe.user.dao.UserDao;
import com.sframe.user.model.User;
import com.sframe.user.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public Page getUserPage(ParamsMap paramsMap) throws Exception {
        QueryMap queryMap = new QueryMap();
        queryMap.setPageNum(paramsMap.getPageNumber());
        queryMap.setCURRENT_ROWS_SIZE(paramsMap.getPageSize());
        Map map = paramsMap.getParams();
        List params = new ArrayList();
        StringBuffer sb = new StringBuffer();
        sb.append("  SELECT  ");
        sb.append("  	u.user_id,  ");
        sb.append("  	u.user_account,  ");
        sb.append("  	u.user_name,  ");
        sb.append("  	r.role_name,  ");
        sb.append("  	u.user_email,  ");
        sb.append("  	u.user_phone,  ");
        sb.append("  	u.create_time,  ");
        sb.append("  	u.last_login_time  ");
        sb.append("  FROM  ");
        sb.append("  	sys_user u  ");
        sb.append("  LEFT JOIN sys_role r ON u.role_id = r.role_id  ");
        sb.append("  WHERE  ");
        sb.append("      1=1  ");
        if(!StringUtil.isEmpty(MapUtils.getString(map,"isEnabled"))){
            sb.append("  AND u.is_enable=?  ");
            params.add(MapUtils.getString(map,"isEnabled"));
        }
        if(!StringUtil.isEmpty(MapUtils.getString(map,"userAccount"))){
            sb.append("  AND u.user_account LIKE ?  ");
            params.add("%"+MapUtils.getString(map,"userAccount")+"%");
        }
        if(!StringUtil.isEmpty(MapUtils.getString(map,"userName"))){
            sb.append("  AND u.user_name LIKE ?  ");
            params.add("%"+MapUtils.getString(map,"userName")+"%");
        }
        if(!StringUtil.isEmpty(MapUtils.getString(map,"userEmail"))){
            sb.append("  AND u.user_email LIKE ?  ");
            params.add("%"+MapUtils.getString(map,"userEmail")+"%");
        }
        sb.append("  ORDER BY  ");
        sb.append("  	u.create_time DESC  ");
        Page page = userDao.pagedNativeQuery(sb.toString(),queryMap,params.toArray());
        List result = (List)page.getResult();
        if(CollectionUtils.isNotEmpty(result)){
            for(int i =0;i<result.size();i++){
                Object[] objs = (Object[])result.get(i);
                int index = 0;
                User user = new User();
                user.setUserId(StringUtil.objToString(objs[index++]));
                user.setUserAccount(StringUtil.objToString(objs[index++]));
                user.setUserName(StringUtil.objToString(objs[index++]));
                user.setRoleName(StringUtil.objToString(objs[index++]));
                user.setUserEmail(StringUtil.objToString(objs[index++]));
                user.setUserPhone(StringUtil.objToString(objs[index++]));
                user.setCreateTime((Date)objs[index++]);
                user.setLastLoginTime((Date)objs[index++]);
                result.set(i,user);
            }
        }
        return page;
    }
}
