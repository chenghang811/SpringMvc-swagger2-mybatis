package com.org.entity.system;

import java.io.Serializable;

public class User implements Serializable{

    private static final long serialVersionUID = -9174546191580050755L;
    
    private Long id;
    
    private String userName;
    
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    

}
