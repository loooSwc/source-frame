package com.sframe.user.model;

public class User extends BaseUser {
    String roleName;            //角色名称

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
