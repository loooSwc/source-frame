package com.sframe.user.model;

public class User extends BaseUser {
    String roleName;            //角色名称

    String isEnableName;        //启用/禁用
  public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getIsEnableName() {
        return isEnableName;
    }

    public void setIsEnableName(String isEnableName) {
        this.isEnableName = isEnableName;
    }
}
