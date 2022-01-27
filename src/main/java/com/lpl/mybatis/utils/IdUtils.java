package com.lpl.mybatis.utils;

import java.util.UUID;

/**
 * @author lipenglong
 * @version 1.0
 * @describe
 */
public class IdUtils {
    public static String getId(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
