package com.sframe.user.service.impl;

import com.sframe.common.ConstantClazz;
import com.sframe.common.dao.ParamsMap;
import com.sframe.common.dao.QueryMap;
import com.sframe.common.dao.support.Page;
import com.sframe.common.util.*;
import com.sframe.user.dao.UserDao;
import com.sframe.user.model.BaseUser;
import com.sframe.user.model.User;
import com.sframe.user.service.UserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.servlet.http.HttpSession;
import java.math.BigInteger;
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
        sb.append("  	u.last_login_time,  ");
        sb.append("  	u.is_enable  ");
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
                user.setIsEnable(StringUtil.objToString(objs[index++]));
                result.set(i,user);
            }
        }
        return page;
    }

	@Override
	public User getUserDetail(String userId) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append("  SELECT  ");
        sb.append("          u.user_id,  ");
        sb.append("          u.user_account,  ");
        sb.append("          u.user_name,  ");
        sb.append("          u.is_enable,  ");
        sb.append("          r.role_name,  ");
        sb.append("          u.user_phone,  ");
        sb.append("          u.user_email   ");
        sb.append("  FROM  ");
        sb.append("          sys_user u  ");
        sb.append("          LEFT JOIN sys_role r ON u.role_id = r.role_id   ");
        sb.append("  WHERE  ");
        sb.append("          u.user_id = ?   ");
        sb.append("  ORDER BY  ");
        sb.append("          u.create_time DESC  ");
        Query query = userDao.createSQLNativeQuery(sb.toString(),userId);
        List result = query.getResultList();
        User user = null;
        if(CollectionUtils.isNotEmpty(result)){
            Object[] objs = (Object[])result.get(0);
            user = new User();
            int index = 0;
            user.setUserId(StringUtil.objToString(objs[index++]));
            user.setUserAccount(StringUtil.objToString(objs[index++]));
            user.setUserName(StringUtil.objToString(objs[index++]));
            user.setIsEnable(StringUtil.objToString(objs[index++]));
            user.setRoleName(StringUtil.objToString(objs[index++]));
            user.setUserPhone(StringUtil.objToString(objs[index++]));
            user.setUserEmail(StringUtil.objToString(objs[index++]));
        }
		return user;
	}

	@Override
	public void addUser(User user) throws Exception {
        user.setIsEnable("1");
        user.setCreateTime(new Date());
        HttpSession session = SessionUtil.getSession();
        String key = (String) session.getAttribute(ConstantClazz.SYS_SESSION_PASSWORD_REGISTER);
        session.removeAttribute(ConstantClazz.SYS_SESSION_PASSWORD_REGISTER);
        String password = DesUtil.strDec(user.getUserPassword(), key, null, null);
        int salt = (int)((Math.random()*9+1)*100000);
        String userSalt = StringUtil.objToString(salt);
        String saltPassword = AuthUtil.createSaltPassword(password , userSalt);
        user.setUserPassword(saltPassword);
        user.setSalt(userSalt);
        BaseUser baseUser = new BaseUser();
        BeanUtils.copyPropertiesByModel(baseUser,user);
        userDao.saveOrUpdate(baseUser);
	}

    @Override
    public boolean checkUserAccount(String userAccount) throws Exception {
        StringBuffer sb = new StringBuffer();
        sb.append(" 	SELECT		   ");
        sb.append(" 		count(1)	   ");
        sb.append(" 	FROM		   ");
        sb.append(" 		sys_user 	   ");
        sb.append(" 	WHERE		   ");
        sb.append(" 		user_account = ?	   ");
        Query query = userDao.createSQLNativeQuery(sb.toString(),userAccount);
        Object o = query.getSingleResult();
        int totalCount =0;
        if(o instanceof BigInteger){
            totalCount = ((BigInteger)o).intValue();
        }
        return totalCount > 0;
    }

    @Override
    public void editUser(User user) throws Exception {
        List params =new ArrayList();
        params.add(user.getUserName());
        params.add(user.getUserPhone());
        params.add(user.getUserEmail());
        params.add(user.getUserId());
        userDao.execSQL("UPDATE sys_user SET user_name = ?, user_phone = ?, user_email = ? WHERE user_id = ?",params.toArray());
    }

    @Override
    public void changeStatus(User user) throws Exception {
        userDao.execSQL("UPDATE sys_user SET is_enable = ? WHERE user_id = ?",user.getIsEnable(),user.getUserId());
    }
}
