package com.webshiro.entity;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
public class Permission {
    private static final long serialVersionUID=1L;

    private String id;
    private String permission;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
