package com.webshiro.entity;

import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2016/2/11 0011.
 */
public class Role {

    private static final long serialVersionUID=1L;
    private String id;
    private String roleName;
    private List<Permission> permissions;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}
