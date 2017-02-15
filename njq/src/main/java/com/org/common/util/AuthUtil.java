package com.org.common.util;

import org.apache.shiro.SecurityUtils;

import com.org.entity.system.User;

public class AuthUtil {
    
    private AuthUtil(){
        
    }
    public static User getUser(){
       return  (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }
}
