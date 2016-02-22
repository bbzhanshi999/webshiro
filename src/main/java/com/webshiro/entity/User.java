package com.webshiro.entity;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
public class User {

    private static final long serialVersionUID = 1L;
    private String id;
    private String userName;
    private String password;
    private String salt;
    private List<Role> roles;
    private List<Permission> permissions;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }


}
