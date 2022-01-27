package com.lpl.mybatis.utils;

import java.util.UUID;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
@SuppressWarnings("all") //抑制警告
public class IdUtil {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
