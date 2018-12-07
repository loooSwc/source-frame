package com.sframe.common.util;

public class RandomUtil {
    public static String getRandomStr(int length){
        StringBuffer result=new StringBuffer();
        for(int i=0; i<length;i++){
            int a = (int) ( Math.random () * 3 );
            if(a==0){
                result.append((int) ( Math.random () * 10 ));
            }else if(a==1){
                result.append((char) ( (int) ( Math.random () * 26 ) + 65 ) );
            }else{
                result.append((char) ( (int) ( Math.random () * 26 ) + 97 ));
            }
        }
        return result.toString();
    }
}
