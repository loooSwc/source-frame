package com.sframe.common.util;

public class AuthUtil {

    /**
     * @Author c.9u@outlook.com
     * @Description  密码加盐，算法是：md5(md5(password)+salt)
     * @Date 17:37 2018/11/17
     * @Param
     * @return
     **/
    public static String createSaltPassword(String password , String salt) {
        String saltPassword = "";
        MD5 md5 = new MD5();
        String pass = md5.getMD5ofStr(password);
        saltPassword = md5.getMD5ofStr(pass+salt);
        return saltPassword;
    }
}
