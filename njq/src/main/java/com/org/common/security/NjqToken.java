package com.org.common.security;

import org.apache.shiro.authc.UsernamePasswordToken;

public class NjqToken extends UsernamePasswordToken{
    
    private static final long serialVersionUID = 8076598577404171960L;

    public NjqToken() {
        super();
    }
    
    public NjqToken(String username, String password,
            boolean rememberMe, String host) {
        super(username, password, rememberMe, host);
    }
    
    public NjqToken(String username, String password) {
        super(username, password);
    }
}
