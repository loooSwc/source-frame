package com.sframe.common.model;

import com.sframe.common.util.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;


/**
 * @Author c.9u@outlook.com
 * @Description  session信息
 * @Date 17:38 2018/11/17
 * @Param
 * @return
 **/
public class SessionUserInfo implements Serializable {
    private static final Logger log              = LoggerFactory.getLogger(SessionUserInfo.class);
    /**
     *Comment for <code>serialVersionUID</code>
     */
    private static final long   serialVersionUID = 1737797028593737241L;

    private String userId;			//用户ID
    private String userAccount;	    //用户账号
    private String userName;		//用户名
    private String roleId;			//角色ID
    private String roleName;		//角色名称
    private String roleSign;		//角色标识
    private String phone;			//联系电话
    private String email;			//邮箱
    private Date lastTime;		//上次登录时间
    private String IP;				//登录IP

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleSign() {
		return roleSign;
	}

	public void setRoleSign(String roleSign) {
		this.roleSign = roleSign;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public String getIP() {
		return IP;
	}

	public void setIP(String IP) {
		this.IP = IP;
	}

	@Override
    public String toString() {
        Field[] fields = BeanUtils.getDeclaredFields(SessionUserInfo.class);
        StringBuffer sb = new StringBuffer();
        try {
            for (Field field : fields) {
                sb.append(field.getName() + ":");
                sb.append(field.get(this));
                sb.append(";");
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        return sb.toString();
    }

}
