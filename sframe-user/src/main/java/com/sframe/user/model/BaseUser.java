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
}