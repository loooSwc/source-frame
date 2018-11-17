package com.sframe.user.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: cxy@acmtc.com
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
}