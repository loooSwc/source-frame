package com.sframe.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: c.9u@outlook.com
 * \* Date: 2018/11/5
 * \* Time: 16:56
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@Entity
@Table(name = "sys_user")
public class BaseUser implements java.io.Serializable {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	@Column(name = "user_id", unique = true, nullable = false, length = 32)
	private String userId;         //账号id
	@Column(name = "user_account", length = 32)
	private String userAccount;    //账号
	@Column(name = "user_password")
	private String userPassword;    //密码
	@Column(name = "salt")
	private String salt;            //密码盐

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "create_time")
	private Date createTime;            //创建时间

	@Column(name = "is_enable")
	private String isEnable;        //是否启用 1为启用，0为禁用

	@Column(name = "role_id")
	private String roleId;        //角色Id

	@Column(name = "user_name")
	private String userName;        // 用户名称

	@Column(name = "user_phone")
	private String userPhone;        // 手机号

	@Column(name = "user_email")
	private String userEmail;        // 用户邮箱

	@Temporal(value = TemporalType.TIMESTAMP)
	@Column(name = "last_login_time")
	private Date lastLoginTime;            //最后登陆时间


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

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getIsEnable() {
		return isEnable;
	}

	public void setIsEnable(String isEnable) {
		this.isEnable = isEnable;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public Date getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}
}